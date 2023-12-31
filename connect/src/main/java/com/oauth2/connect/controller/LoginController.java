// package com.oauth2.connect.controller;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.core.ResolvableType;
// import org.springframework.security.oauth2.client.registration.ClientRegistration;
// import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
// import org.springframework.stereotype.Controller;
// import org.springframework.web.bind.annotation.GetMapping;
// import java.util.*;
// import ch.qos.logback.core.model.Model;
// import org.springframework.security.oauth2.client.registration.ClientRegistration;
// import org.springframework.context.annotation.Bean;

// @Controller
// public class LoginController {

//     private static String authorizationRequestBaseUri
//       = "oauth2/authorization";
//     Map<String, String> oauth2AuthenticationUrls = new HashMap<>();

//     @Autowired
//     private ClientRegistrationRepository clientRegistrationRepository;

//     @GetMapping("/oauth_login")
//     public String getLoginPage(Model model) {
//     Iterable<ClientRegistration> clientRegistrations = null;
//     ResolvableType type = ResolvableType.forInstance(clientRegistrationRepository)
//       .as(Iterable.class);
//     if (type != ResolvableType.NONE && 
//       ClientRegistration.class.isAssignableFrom(type.resolveGenerics()[0])) {
//         clientRegistrations = (Iterable<ClientRegistration>) clientRegistrationRepository;
//     }

//     clientRegistrations.forEach(registration -> 
//       oauth2AuthenticationUrls.put(registration.getClientName(), 
//       authorizationRequestBaseUri + "/" + registration.getRegistrationId()));
//     model.addAttribute("urls", oauth2AuthenticationUrls);

//     return "oauth_login";
// }
    
// }