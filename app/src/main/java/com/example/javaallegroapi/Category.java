package com.example.javaallegroapi;

import java.util.List;

public class Category {
    private List<CategoriesBean> categories;

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

        private String id;
        private String name;
        private Object parent;
        private boolean leaf;
        private OptionsBean options;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Object getParent() {
            return parent;
        }

        public void setParent(Object parent) {
            this.parent = parent;
        }

        public boolean isLeaf() {
            return leaf;
        }

        public void setLeaf(boolean leaf) {
            this.leaf = leaf;
        }

        public OptionsBean getOptions() {
            return options;
        }

        public void setOptions(OptionsBean options) {
            this.options = options;
        }

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
