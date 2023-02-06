package com.colegio;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import software.amazon.awssdk.auth.credentials.ProfileCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.cognitoidentityprovider.CognitoIdentityProviderClient;

@SpringBootTest
class UsuarioCognitoApplicationTests {
	
	@Test
	void contextLoads() {
		/*String authFlow = "USER_PASSWORD_AUTH";
        String clientId = "6641hk7g0mov9hfvmujlmdv8hm";
        String userPoolId = " us-east-1_ziuwKlwmU";

        CognitoIdentityProviderClient identityProviderClient = CognitoIdentityProviderClient.builder()
                .region(Region.US_EAST_1)
                .credentialsProvider(ProfileCredentialsProvider.create())
                .build();

        UsuarioServiceImpl.SignIn(identityProviderClient, "1090378874", "12345Jai.");
        identityProviderClient.close();*/
	}

}
