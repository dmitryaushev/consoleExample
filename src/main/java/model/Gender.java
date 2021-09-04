package model;

import java.util.Arrays;
import java.util.Optional;

public enum Gender {
    MALE("MALE"),
    FEMALE("FEMALE");

    Gender(String gender) {
        this.gender = gender;
    }

    private String gender;

    public String getGender() {
        return gender;
    }

    public static Optional<Gender> getGender(String gender) {
        return Arrays.stream(Gender.values())
                .filter(enumValue -> enumValue.getGender().equals(gender))
                .findAny();
    }
}
