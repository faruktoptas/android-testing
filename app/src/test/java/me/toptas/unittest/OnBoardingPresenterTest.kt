package me.toptas.unittest

import com.nhaarman.mockitokotlin2.*
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito

class OnBoardingPresenterTest {

    lateinit var presenter: OnBoardingPresenter
    lateinit var view: OnBoardingView
    lateinit var repo: PreferenceRepository

    @Before
    fun setup() {
        view = Mockito.mock(OnBoardingView::class.java)
        repo = Mockito.mock(PreferenceRepository::class.java)

        presenter = OnBoardingPresenter(repo, view)
    }

    @Test
    fun testShowOnBoarding() {
        Mockito.`when`(repo.isBoardingSeen())
            .thenReturn(false)

        presenter.check()

        verify(view).showOnBoarding()
        verify(repo).setOnBoardingSeen()
    }

    @Test
    fun testShowLogin() {
        Mockito.`when`(repo.isBoardingSeen())
            .thenReturn(true)

        presenter.check()

        verify(view).showLogin()
        verify(view, never()).showOnBoarding()

        argumentCaptor<String> {
            verify(repo).setToken(capture())
            print("value $firstValue")
            assert(firstValue == "123")
        }
    }
}