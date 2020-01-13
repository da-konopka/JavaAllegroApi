package com.example.javaallegroapi;

import java.util.List;

public class Product {
    

    /**
     * items : {"promoted":[],"regular":[{"id":"6206807884","name":"Volkswagen Passat (Nie audi, bmw, mercedes, honda)","seller":{"id":"44139160","company":true,"superSeller":false},"promotion":{"emphasized":false,"bold":false,"highlight":false},"delivery":{"availableForFree":true,"lowestPrice":{"amount":"0.00","currency":"PLN"}},"images":[],"sellingMode":{"format":"BUY_NOW","price":{"amount":"7.38","currency":"PLN"},"popularity":0},"stock":{"unit":"UNIT","available":15},"category":{"id":"111852"},"publication":{"endingAt":"2020-02-01T07:14:59.000Z"}}]}
     * searchMeta : {"availableCount":1,"totalCount":1,"fallback":false}
     * categories : {"subcategories":[{"id":"1520","name":"Budownictwo i Akcesoria","count":1}],"path":[{"id":"954b95b6-43cf-4104-8354-dea4d9b10ddf","name":"Allegro"},{"id":"5","name":"Dom i Ogród"}]}
     * filters : [{"id":"parameter.11323","type":"MULTI","name":"Stan","values":[{"value":"11323_1","name":"nowe","count":1,"selected":false}]},{"id":"sellingMode.format","type":"MULTI","name":"rodzaj oferty","values":[{"value":"BUY_NOW","name":"kup teraz","count":0,"selected":false},{"value":"AUCTION","name":"licytacje","count":0,"selected":false}]},{"id":"price","type":"NUMERIC","name":"cena","values":[{"idSuffix":".from","name":"od","selected":false},{"idSuffix":".to","name":"do","selected":false}],"minValue":0,"maxValue":1000000000,"unit":"zł"},{"id":"deliveryMethod","type":"MULTI","name":"sposoby dostawy","values":[{"value":"5b445fa0580ce26bb2f99602","name":"Kurier","count":1,"selected":false},{"value":"5b445fd9580ce26bb2f99608","name":"Kurier wieczór","count":0,"selected":false},{"value":"5b445fe6580ce26bb2f9960a","name":"Paczkomaty InPost","count":0,"selected":false},{"value":"5b446004580ce26bb2f9960c","name":"Odbiór w punkcie","count":1,"selected":false},{"value":"5b446013580ce26bb2f9960e","name":"List","count":0,"selected":false},{"value":"5b446031580ce26bb2f99610","name":"Paczka","count":1,"selected":false},{"value":"5b44606c580ce26bb2f99616","name":"Ekspresowa dostawa","count":0,"selected":false},{"value":"5b446044580ce26bb2f99612","name":"Odbiór osobisty","count":0,"selected":false},{"value":"5b44605c580ce26bb2f99614","name":"Przesyłka elektroniczna","count":1,"selected":false}]},{"id":"location.city","type":"TEXT","name":"miejscowość","values":[{"name":"miejscowość","selected":false}]},{"id":"location.province","type":"SINGLE","name":"województwo","values":[{"value":"DOLNOSLASKIE","name":"z dolnośląskiego","selected":false},{"value":"KUJAWSKO_POMORSKIE","name":"z kujawsko-pomorskiego","selected":false},{"value":"LUBELSKIE","name":"z lubelskiego","selected":false},{"value":"LUBUSKIE","name":"z lubuskiego","selected":false},{"value":"LODZKIE","name":"z łódzkiego","selected":false},{"value":"MALOPOLSKIE","name":"z małopolskiego","selected":false},{"value":"MAZOWIECKIE","name":"z mazowieckiego","selected":false},{"value":"OPOLSKIE","name":"z opolskiego","selected":false},{"value":"PODKARPACKIE","name":"z podkarpackiego","selected":false},{"value":"PODLASKIE","name":"z podlaskiego","selected":false},{"value":"POMORSKIE","name":"z pomorskiego","selected":false},{"value":"SLASKIE","name":"ze śląskiego","selected":false},{"value":"SWIETOKRZYSKIE","name":"ze świętokrzyskiego","selected":false},{"value":"WARMINSKO_MAZURSKIE","name":"z warmińsko-mazurskiego","selected":false},{"value":"WIELKOPOLSKIE","name":"z wielkopolskiego","selected":false},{"value":"ZACHODNIOPOMORSKIE","name":"z zachodniopomorskiego","selected":false}]},{"id":"option","type":"MULTI","name":"oferta ma","values":[{"value":"FREE_SHIPPING","name":"darmowa dostawa","selected":false},{"value":"FREE_RETURN","name":"darmowy zwrot","selected":false},{"value":"VAT_INVOICE","name":"faktura VAT","selected":false},{"value":"COINS","name":"Monety Allegro","selected":false},{"value":"BRAND_ZONE","name":"Strefa Marek","selected":false},{"value":"SUPERSELLER","name":"Super Sprzedawca","selected":false},{"value":"CHARITY","name":"Allegro Charytatywni","selected":false},{"value":"SMART","name":"Allegro Smart!","selected":false}]},{"id":"campaign","type":"MULTI","name":"kampania","values":[{"value":"BARGAIN","name":"Strefa Okazji","selected":false},{"value":"BARGAIN_REBATE","name":"rabaty","selected":false}]}]
     * sort : [{"value":"-relevance","name":"trafność","order":"największa","selected":true},{"value":"+price","name":"cena","order":"od najniższej","selected":false},{"value":"-price","name":"cena","order":"od najwyższej","selected":false},{"value":"+withDeliveryPrice","name":"cena z dostawą","order":"od najniższej","selected":false},{"value":"-withDeliveryPrice","name":"cena z dostawą","order":"od najwyższej","selected":false},{"value":"-popularity","name":"popularność","order":"największa","selected":false},{"value":"+endTime","name":"czas do końca","order":"najmniej","selected":false},{"value":"-startTime","name":"czas dodania","order":"najnowsze","selected":false}]
     */

    public ItemsBean items;
    public SearchMetaBean searchMeta;
    public CategoriesBean categories;
    public List<FiltersBean> filters;
    public List<SortBean> sort;


    public static class ItemsBean {
        public List<?> promoted;
        public List<RegularBean> regular;

        public static class RegularBean {
            /**
             * id : 6206807884
             * name : Volkswagen Passat (Nie audi, bmw, mercedes, honda)
             * seller : {"id":"44139160","company":true,"superSeller":false}
             * promotion : {"emphasized":false,"bold":false,"highlight":false}
             * delivery : {"availableForFree":true,"lowestPrice":{"amount":"0.00","currency":"PLN"}}
             * images : []
             * sellingMode : {"format":"BUY_NOW","price":{"amount":"7.38","currency":"PLN"},"popularity":0}
             * stock : {"unit":"UNIT","available":15}
             * category : {"id":"111852"}
             * publication : {"endingAt":"2020-02-01T07:14:59.000Z"}
             */

            public String id;
            public String name;
            public SellerBean seller;
            public PromotionBean promotion;
            public DeliveryBean delivery;
            public SellingModeBean sellingMode;
            public StockBean stock;
            public CategoryBean category;
            public PublicationBean publication;
            public List<?> images;

            public static class SellerBean {
                /**
                 * id : 44139160
                 * company : true
                 * superSeller : false
                 */

                public String id;
                public boolean company;
                public boolean superSeller;
            }

            public static class PromotionBean {
                /**
                 * emphasized : false
                 * bold : false
                 * highlight : false
                 */

                public boolean emphasized;
                public boolean bold;
                public boolean highlight;

            }

            public static class DeliveryBean {
                /**
                 * availableForFree : true
                 * lowestPrice : {"amount":"0.00","currency":"PLN"}
                 */

                public boolean availableForFree;
                public LowestPriceBean lowestPrice;

                public static class LowestPriceBean {
                    /**
                     * amount : 0.00
                     * currency : PLN
                     */

                    public String amount;
                    public String currency;

                }
            }

            public static class SellingModeBean {
                /**
                 * format : BUY_NOW
                 * price : {"amount":"7.38","currency":"PLN"}
                 * popularity : 0
                 */

                public String format;
                public PriceBean price;
                public int popularity;


                public static class PriceBean {
                    /**
                     * amount : 7.38
                     * currency : PLN
                     */

                    public String amount;
                    public String currency;
                }
            }

            public static class StockBean {
                /**
                 * unit : UNIT
                 * available : 15
                 */

                public String unit;
                public int available;
            }

            public static class CategoryBean {
                /**
                 * id : 111852
                 */

                public String id;
            }

            public static class PublicationBean {
                /**
                 * endingAt : 2020-02-01T07:14:59.000Z
                 */

                public String endingAt;
            }
        }
    }

    public static class SearchMetaBean {
        /**
         * availableCount : 1
         * totalCount : 1
         * fallback : false
         */

        public int availableCount;
        public int totalCount;
        public boolean fallback;
    }

    public static class CategoriesBean {
        public List<SubcategoriesBean> subcategories;
        public List<PathBean> path;

        public static class SubcategoriesBean {
            /**
             * id : 1520
             * name : Budownictwo i Akcesoria
             * count : 1
             */

            public String id;
            public String name;
            public int count;
        }

        public static class PathBean {
            /**
             * id : 954b95b6-43cf-4104-8354-dea4d9b10ddf
             * name : Allegro
             */

            public String id;
            public String name;
        }
    }

    public static class FiltersBean {
        /**
         * id : parameter.11323
         * type : MULTI
         * name : Stan
         * values : [{"value":"11323_1","name":"nowe","count":1,"selected":false}]
         * minValue : 0
         * maxValue : 1000000000
         * unit : zł
         */

        public String id;
        public String type;
        public String name;
        public int minValue;
        public int maxValue;
        public String unit;
        public List<ValuesBean> values;

        public static class ValuesBean {
            /**
             * value : 11323_1
             * name : nowe
             * count : 1
             * selected : false
             */

            public String value;
            public String name;
            public int count;
            public boolean selected;
        }
    }

    public static class SortBean {
        /**
         * value : -relevance
         * name : trafność
         * order : największa
         * selected : true
         */

        public String value;
        public String name;
        public String order;
        public boolean selected;
    }
}
