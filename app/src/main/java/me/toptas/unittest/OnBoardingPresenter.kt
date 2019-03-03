package me.toptas.unittest

class OnBoardingPresenter(private val repo: PreferenceRepository, private val view: OnBoardingView) {

    fun check() {
        if (!repo.isBoardingSeen()) {
            view.showOnBoarding()
            repo.setOnBoardingSeen()
        } else {
            view.showLogin()
            repo.setToken("123")
        }
    }

}

interface OnBoardingView {
    fun showOnBoarding()
    fun showLogin()
}