package com.colegio;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import software.amazon.awssdk.auth.credentials.ProfileCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.cognitoidentityprovider.CognitoIdentityProviderClient;
import software.amazon.awssdk.services.cognitoidentityprovider.model.AuthFlowType;
import software.amazon.awssdk.services.cognitoidentityprovider.model.CognitoIdentityProviderException;
import software.amazon.awssdk.services.cognitoidentityprovider.model.InitiateAuthRequest;
import software.amazon.awssdk.services.cognitoidentityprovider.model.InitiateAuthResponse;

@SpringBootApplication
public class UsuarioCognitoApplication {

	public static void main(String[] args) {
		SpringApplication.run(UsuarioCognitoApplication.class, args);
		CognitoIdentityProviderClient identityProviderClient = CognitoIdentityProviderClient.builder()
				.region(Region.US_EAST_1).credentialsProvider(ProfileCredentialsProvider.create()).build();

		System.out.println(signIn(identityProviderClient, "1090378874", "12345Jai."));
		identityProviderClient.close();
	}

	public static InitiateAuthResponse signIn(CognitoIdentityProviderClient identityProviderClient, String username,
			String password) {
		try {
			Map<String, String> authParameters = new HashMap<>();
			authParameters.put("USERNAME", username);
			authParameters.put("PASSWORD", password);
			InitiateAuthRequest authRequest = InitiateAuthRequest.builder().clientId("6641hk7g0mov9hfvmujlmdv8hm")
					.authParameters(authParameters).authFlow(AuthFlowType.USER_PASSWORD_AUTH).build();

			InitiateAuthResponse response = identityProviderClient.initiateAuth(authRequest);
			//Obtiene el id token del usuario, se puede obtener el access token
			System.out.println(response.authenticationResult().idToken());
			System.out.println("Result Challenge is : " + response.challengeName());
			return response;
		} catch (CognitoIdentityProviderException e) {
			System.err.println(e.awsErrorDetails().errorMessage());
			System.exit(1);
		}

		return null;
	}
}
