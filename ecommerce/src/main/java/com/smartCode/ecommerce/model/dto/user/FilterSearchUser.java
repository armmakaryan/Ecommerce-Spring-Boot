package com.smartCode.ecommerce.model.dto.user;

import com.smartCode.ecommerce.util.constants.Gender;
import lombok.Getter;
import lombok.Setter;

public class FilterSearchUser {
    @Getter
    @Setter
    public static class Filter {
        private Integer startAge;
        private Integer endAge;
        private Boolean isVerified;
        private Gender gender;
        //private String productName;
    }

    @Setter
    @Getter
    public static class Search {
        private String text;
    }
}