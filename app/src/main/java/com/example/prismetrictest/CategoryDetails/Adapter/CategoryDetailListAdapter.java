package com.example.prismetrictest.CategoryDetails.Adapter;

import static com.example.prismetrictest.Util.Constance.EMPTY;
import static com.example.prismetrictest.Util.Constance.LATITUDE;
import static com.example.prismetrictest.Util.Constance.LONGITUDE;
import static com.example.prismetrictest.Util.Constance.SP_COMA;
import static com.example.prismetrictest.Util.Constance.ZERO;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.prismetrictest.CategoryDetails.model.UserResponseModel;
import com.example.prismetrictest.Map.MapActivity;
import com.example.prismetrictest.R;

import java.util.List;

public class CategoryDetailListAdapter extends RecyclerView.Adapter<CategoryDetailListAdapter.MyViewHolder> {

  private Context mContext;
  private List<UserResponseModel> mUserResponseModelList;

  public CategoryDetailListAdapter(List<UserResponseModel> userResponseModelList) {
    this.mUserResponseModelList = userResponseModelList;
  }

  @Override
  public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    this.mContext = parent.getContext();
    LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
    View listItem = layoutInflater.inflate(R.layout.item_category_detail_list, parent, false);
    MyViewHolder viewHolder = new MyViewHolder(listItem);
    return viewHolder;
  }

  @Override
  public void onBindViewHolder(MyViewHolder holder, int position) {
    UserResponseModel data = mUserResponseModelList.get(position);

    StringBuilder address = new StringBuilder();
    address.append(data.getAddress().getSuite() != null && !data.getAddress().getSuite().equals(EMPTY) ? data.getAddress().getSuite().concat(SP_COMA) : EMPTY);
    address.append(data.getAddress().getStreet() != null && !data.getAddress().getStreet().equals(EMPTY) ? data.getAddress().getStreet().concat(SP_COMA) : EMPTY);
    address.append(data.getAddress().getCity() != null && !data.getAddress().getCity().equals(EMPTY) ? data.getAddress().getCity().concat(SP_COMA) : EMPTY);
    address.append(data.getAddress().getZipcode() != null && !data.getAddress().getZipcode().equals(EMPTY) ? data.getAddress().getZipcode().concat(SP_COMA) : EMPTY);

    holder.tvName.setText(data.getName() != null && !data.getName().equals(EMPTY) ? data.getName() : EMPTY);
    holder.tvEmail.setText(data.getEmail() != null && !data.getEmail().equals(EMPTY) ? data.getEmail() : EMPTY);
    holder.tvAddress.setText(!address.toString().equals(EMPTY) ? address.toString() : EMPTY);

    holder.tvCompanyName.setText(data.getCompany().getName() != null && !data.getCompany().getName().equals(EMPTY) ? data.getCompany().getName() : EMPTY);
    holder.tvWebsite.setText(data.getWebsite() != null && !data.getWebsite().equals(EMPTY) ? data.getWebsite() : EMPTY);
    holder.tvCompanyNumber.setText(data.getPhone() != null && !data.getPhone().equals(EMPTY) ? data.getPhone() : EMPTY);

    holder.itemView.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        Intent intent = new Intent(mContext, MapActivity.class);
        intent.putExtra(LATITUDE,data.getAddress().getGeo().getLat());
        intent.putExtra(LONGITUDE,data.getAddress().getGeo().getLng());
        mContext.startActivity(intent);
      }
    });
  }

  @Override
  public int getItemCount() {
    return mUserResponseModelList != null && mUserResponseModelList.size() > ZERO
        ? mUserResponseModelList.size() : ZERO;
  }

  public class MyViewHolder extends RecyclerView.ViewHolder {

    TextView tvName, tvEmail, tvAddress, tvCompanyName, tvWebsite, tvCompanyNumber;

    public MyViewHolder(View itemView) {
      super(itemView);

      tvName = itemView.findViewById(R.id.tvName);
      tvEmail = itemView.findViewById(R.id.tvEmail);
      tvAddress = itemView.findViewById(R.id.tvAddress);
      tvCompanyName = itemView.findViewById(R.id.tvCompanyName);
      tvWebsite = itemView.findViewById(R.id.tvWebsite);
      tvCompanyNumber = itemView.findViewById(R.id.tvCompanyNumber);

    }
  }
}
