package helpers.enums;

public class GenderEnums {

    public enum Gender {
        GENDER_MR("Mr"),
        GENDER_MRS("Mrs");

        private final String genderEnums;

        Gender(String genderEnums) {
            this.genderEnums = genderEnums;
        }
        public String getGender() {
            return this.genderEnums;
        }
    }
}
