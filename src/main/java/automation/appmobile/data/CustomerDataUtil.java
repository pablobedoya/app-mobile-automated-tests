package automation.appmobile.data;

import com.github.javafaker.Faker;

public final class CustomerDataUtil {

	private static Faker faker = new Faker();

	private CustomerDataUtil() {
	}

	public static String generateName() {
		return faker.name().name();
	}

	public static String generatePhone() {
		return faker.phoneNumber().phoneNumber();
	}

}
