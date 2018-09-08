package com.arya.cart.fragment;


import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.arya.cart.R;
import com.arya.cart.adapter.ProductItemViewAdapter;
import com.arya.cart.constant.Constants;
import com.arya.cart.model.Product;
import com.arya.cart.util.ImageUrls;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class ProductsFragment extends Fragment {

    private RecyclerView mProductsListView;

    private ProductItemViewAdapter mProductItemViewAdapter;

    private StaggeredGridLayoutManager mStaggeredGridLayoutManager;

    private GetProductsAsyncTask mGetProductsAsyncTask;

    public ProductsFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_products, container, false);
        mProductsListView = view.findViewById(R.id.products_list_view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        String item = ProductsFragment.this.getArguments().getString(Constants.PRODUCT_ITEM);
        if (item != null) {
            mGetProductsAsyncTask = new GetProductsAsyncTask();
            mGetProductsAsyncTask.execute();
        }
    }

    private void setProducts(List<Product> products) {
        mStaggeredGridLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        mProductsListView.setLayoutManager(mStaggeredGridLayoutManager);

        mProductItemViewAdapter = new ProductItemViewAdapter(getActivity(), products);
        mProductsListView.setAdapter(mProductItemViewAdapter);
    }

    /**
     * AsyncTask to get products data & set in the list
     */
    private class GetProductsAsyncTask extends AsyncTask<Void, Void, List<Product>> {

        /**
         * used to get products data in a separate thread
         * @param voids
         * @return List<Product>
         */
        @Override
        protected List<Product> doInBackground(Void... voids) {
            String[] urls = ImageUrls.imageUrls;
            List<Product> products = new ArrayList<>();

            for (int i = 0; i < 20; i++) {
                Product product = new Product();
                product.setUrl(urls[i]);
                product.setProductName("Product : " + i);
                product.setProductDescription("Product Descriptions");

                products.add(product);
            }
            return products;
        }

        /**
         * Set the adapter after getting the products
         * @param products
         */
        @Override
        protected void onPostExecute(List<Product> products) {
            super.onPostExecute(products);

            setProducts(products);
        }
    }
}
