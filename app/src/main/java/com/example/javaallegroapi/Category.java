package com.example.javaallegroapi;

import java.util.List;

public class Category {
    public List<CategoriesBean> categories;

    public List<CategoriesBean> getCategories() {
        return categories;
    }

    public void setCategories(List<CategoriesBean> categories) {
        this.categories = categories;
    }

    public static class CategoriesBean {
        /**
         * id : 5
         * name : Dom i Ogród
         * parent : null
         * leaf : false
         * options : {"variantsByColorPatternAllowed":true,"advertisement":false,"advertisementPriceOptional":false,"offersWithProductPublicationEnabled":false,"productCreationEnabled":false,"productEANRequired":false}
         */

        public String id;
        public String name;
        public Object parent;
        public boolean leaf;
        public OptionsBean options;

        public static class OptionsBean {
            /**
             * variantsByColorPatternAllowed : true
             * advertisement : false
             * advertisementPriceOptional : false
             * offersWithProductPublicationEnabled : false
             * productCreationEnabled : false
             * productEANRequired : false
             */

            private boolean variantsByColorPatternAllowed;
            private boolean advertisement;
            private boolean advertisementPriceOptional;
            private boolean offersWithProductPublicationEnabled;
            private boolean productCreationEnabled;
            private boolean productEANRequired;

            public boolean isVariantsByColorPatternAllowed() {
                return variantsByColorPatternAllowed;
            }

            public void setVariantsByColorPatternAllowed(boolean variantsByColorPatternAllowed) {
                this.variantsByColorPatternAllowed = variantsByColorPatternAllowed;
            }

            public boolean isAdvertisement() {
                return advertisement;
            }

            public void setAdvertisement(boolean advertisement) {
                this.advertisement = advertisement;
            }

            public boolean isAdvertisementPriceOptional() {
                return advertisementPriceOptional;
            }

            public void setAdvertisementPriceOptional(boolean advertisementPriceOptional) {
                this.advertisementPriceOptional = advertisementPriceOptional;
            }

            public boolean isOffersWithProductPublicationEnabled() {
                return offersWithProductPublicationEnabled;
            }

            public void setOffersWithProductPublicationEnabled(boolean offersWithProductPublicationEnabled) {
                this.offersWithProductPublicationEnabled = offersWithProductPublicationEnabled;
            }

            public boolean isProductCreationEnabled() {
                return productCreationEnabled;
            }

            public void setProductCreationEnabled(boolean productCreationEnabled) {
                this.productCreationEnabled = productCreationEnabled;
            }

            public boolean isProductEANRequired() {
                return productEANRequired;
            }

            public void setProductEANRequired(boolean productEANRequired) {
                this.productEANRequired = productEANRequired;
            }
        }
    }
}
