# aws-ejercicios

El metodo para usar la autenticacion de cognito con spring boot y el sdk de JAVA es:
public static InitiateAuthResponse signIn(CognitoIdentityProviderClient identityProviderClient, String username,
			String password) {
		try {
			Map<String, String> authParameters = new HashMap<>();
			authParameters.put("USERNAME", username);
			authParameters.put("PASSWORD", password);
			InitiateAuthRequest authRequest = InitiateAuthRequest.builder().clientId("6641hk7g0mov9hfvmujlmdv8hm")//el codigo es la aplicacion del cliente de cognito
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
