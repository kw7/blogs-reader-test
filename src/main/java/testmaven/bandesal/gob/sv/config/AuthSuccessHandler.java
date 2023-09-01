package testmaven.bandesal.gob.sv.config;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

import lombok.extern.slf4j.Slf4j;

public class AuthSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

	@Override
	protected String determineTargetUrl(HttpServletRequest request, HttpServletResponse response) {

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String role = auth.getAuthorities().toString();

		String targetUrl = null;
		System.out.print(role.concat("EN AUTEN"));
		if (role.contains("ADMIN")) {
			
			targetUrl = "/views/admin/blogs.xhtml";
		} else if (role.contains("USER")) {
			targetUrl = "/views/users/index.xhtml";
		}

		return targetUrl;
	}
}
