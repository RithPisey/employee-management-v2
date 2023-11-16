package kh.gov.rac.racsa.enums;

public class StatusEnum {
    public enum  Status {
        LOW(1),
        MEDIUM(2),
        HIGH(3);

        private final int value;
        Status(int value) {
            this.value = value;
        }
        public int getValue() {
            return value;
        }
    }





}
