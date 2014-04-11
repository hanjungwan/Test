import javapns.back.PushNotificationManager;
import javapns.back.SSLConnectionHelper;
import javapns.data.Device;
import javapns.data.PayLoad;

public class PushTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PayLoad payLoad = new PayLoad();
		
		try {
			payLoad.addBadge(1);
			payLoad.addAlert("최보균");
			payLoad.addSound("default");

			PushNotificationManager pushManager = PushNotificationManager
					.getInstance();
			
			pushManager
					.addDevice("iPhone",
							"ebde554d9c1ac4f1af31069c0ceca0db0a3f7f447f8424a1cec7d224dc1cb8b3");

			System.out.println("Token: "
					+ pushManager.getDevice("iPhone").getToken());

			Device client = pushManager.getDevice("iPhone");
			System.out.println("Client setup successfull.");
			
			pushManager.initializeConnection("gateway.sandbox.push.apple.com",
					2195, "D:\\다운로드 파일\\NexChalDevelopmentCertificate.p12", "nexch0195",
					SSLConnectionHelper.KEYSTORE_TYPE_PKCS12);
			System.out.println("Connection initialized...");

			pushManager.sendNotification(client, payLoad);
			System.out.println("Message sent!");

			System.out.println("# of attempts: "
					+ pushManager.getRetryAttempts());
			pushManager.stopConnection();

			System.out.println("done");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
