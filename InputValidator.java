public static boolean isValidId(int id) {
    return id > 0;
}

public static boolean isValidName(String name) {
    return name != null && !name.trim().isEmpty();
}
