package com.arya.cart.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.arya.cart.R;
import com.arya.cart.model.Product;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * @author Swarn Singh.
 */
public class ProductItemViewAdapter extends Adapter<ProductItemViewAdapter.ProductItemViewHolder> {

    private Context mContext;

    private List<Product> mProducts;

    public ProductItemViewAdapter(Context context, List<Product> products) {
        this.mContext = context;
        this.mProducts = products;
    }

    @NonNull
    @Override
    public ProductItemViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.product_list_item, viewGroup, false);
        return new ProductItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductItemViewHolder productItemViewHolder, int position) {
        Product product = mProducts.get(position);

        Uri uri = Uri.parse(product.getUrl());

        productItemViewHolder.mProductImageView.setImageURI(uri);

        productItemViewHolder.mProductNameTxtView.setText(product.getProductName());

        productItemViewHolder.mProductDescTxtView.setText(product.getProductDescription());

        productItemViewHolder.mProductPriceTxtView.setText(product.getProductPrice());
    }

    @Override
    public int getItemCount() {
        return mProducts.size();
    }

    class ProductItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private View mView;
        private SimpleDraweeView mProductImageView;
        private TextView mProductNameTxtView;
        private TextView mProductPriceTxtView;
        private TextView mProductDescTxtView;
        private LinearLayout mProductLayoutItem;
        private ImageView mProductWishList;

        public ProductItemViewHolder(@NonNull View itemView) {
            super(itemView);
            this.mView = itemView;

            mProductImageView = itemView.findViewById(R.id.product_img_View);
            mProductNameTxtView = itemView.findViewById(R.id.product_name_txt_view);
            mProductDescTxtView = itemView.findViewById(R.id.product_desc_txt_view);
            mProductPriceTxtView = itemView.findViewById(R.id.product_price_txt_view);

            mProductLayoutItem = itemView.findViewById(R.id.product_layout_item);
            mProductWishList = itemView.findViewById(R.id.product_wish_list_img_View);

            mProductLayoutItem.setOnClickListener(this);

            mProductWishList.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (view.getId() == R.id.product_layout_item) {

            } else if (view.getId() == R.id.product_wish_list_img_View) {

            }
        }
    }
}
