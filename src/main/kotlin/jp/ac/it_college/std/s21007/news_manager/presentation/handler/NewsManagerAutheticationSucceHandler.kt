package jp.ac.it_college.std.s21007.news_manager.presentation.handler

import org.springframework.security.core.Authentication
import org.springframework.security.web.authentication.AuthenticationSuccessHandler
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class NewsManagerAutheticationSucceHandler : AuthenticationSuccessHandler {
        override fun onAuthenticationSuccess(
    request: HttpServletRequest?,
    response: HttpServletResponse?,
    authentication: Authentication?
    ) {
        response?.apply {
            status = HttpServletResponse.SC_OK
        }
    }
}