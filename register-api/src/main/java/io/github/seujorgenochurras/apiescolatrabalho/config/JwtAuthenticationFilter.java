//package io.github.seujorgenochurras.apiescolatrabalho.config;
//
//import io.github.seujorgenochurras.apiescolatrabalho.service.JwtService;
//import jakarta.servlet.FilterChain;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.lang.NonNull;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
//import org.springframework.stereotype.Component;
//import org.springframework.web.filter.OncePerRequestFilter;
//
//import java.io.IOException;
//
//@Component
//public class JwtAuthenticationFilter extends OncePerRequestFilter {
//   @Autowired
//   private JwtService jwtService;
//
//   private UserDetailsService userDetailsService;
//
//   @Override
//   protected void doFilterInternal(@NonNull HttpServletRequest request,
//                                   @NonNull HttpServletResponse response,
//                                   @NonNull FilterChain filterChain) throws ServletException, IOException {
//
//      final String requestAuth = request.getHeader("Authorization");
//      final String jwt;
//      if (requestAuth == null || !requestAuth.startsWith("Bearer ")) {
//         filterChain.doFilter(request, response);
//         return;
//      }
//      jwt = requestAuth.substring(7);
//      final String username = jwtService.extractUsernameFromJwt(jwt);
//      if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
//         UserDetails userDetails = this.userDetailsService.loadUserByUsername(username);
//         if (jwtService.validateToken(jwt, userDetails)) {
//            var authenticationToken = new UsernamePasswordAuthenticationToken(userDetails,
//                    null,
//                    userDetails.getAuthorities());
//            authenticationToken.setDetails(
//                    new WebAuthenticationDetailsSource().buildDetails(request));
//            SecurityContextHolder.getContext().setAuthentication(authenticationToken);
//         }
//      }
//   }
//}
