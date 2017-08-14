package itg8.com.treatpriceapp.offer.mvp;

public interface OfferMVP {
    public interface OfferView {
        void onNameAvailable(String name);

        void onMerchantNameAvailable(String name, String logoUrl);

        void onProductCategoryAvailable(String category);

        void onErrorInCatgeoryLoad(String err);
    }

    public interface OfferPresenter {
        void onCategoryIdAvailable(int catId);
    }


}
