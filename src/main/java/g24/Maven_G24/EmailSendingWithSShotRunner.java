package g24.Maven_G24;

public class EmailSendingWithSShotRunner
{
	public static void main(String arg[])
	{

		EmailSendingUkrNet emailSending = new EmailSendingUkrNet();

		emailSending.initialize();

		try
		{
			emailSending.sendEmail();
		} catch (Exception e)
		{
			e.printStackTrace();

		}
		emailSending.driverQuit();

	}
}
