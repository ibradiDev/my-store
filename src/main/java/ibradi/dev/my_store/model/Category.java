package ibradi.dev.my_store.model;

import java.util.HashMap;
import java.util.Map;

public enum Category {
	VEGETABLES(0), FRUITS(1), DAIRYPRODUCT(2), SNACKS(3), CERALS(4), FROZENFOODS(5);

	private static final Map map = new HashMap<>();

	static {
		for (Category category : Category.values()) {
			map.put(category.value, category);
		}
	}

	private final int value;

	Category(int value) {
		this.value = value;
	}

	public static Category valueOf(int category) {
		return (Category) map.get(category);
	}

	public int getValue() {
		return value;
	}
}