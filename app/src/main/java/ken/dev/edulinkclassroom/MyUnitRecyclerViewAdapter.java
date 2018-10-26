package ken.dev.edulinkclassroom;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import ken.dev.edulinkclassroom.Model.CourseUnit;
import ken.dev.edulinkclassroom.UnitFragment.OnListFragmentInteractionListener;


import java.util.List;


public class MyUnitRecyclerViewAdapter extends RecyclerView.Adapter<MyUnitRecyclerViewAdapter.ViewHolder> {

    private final List<CourseUnit> mValues;
    private final OnListFragmentInteractionListener mListener;

    public MyUnitRecyclerViewAdapter(List<CourseUnit> units, OnListFragmentInteractionListener listener) {
        mValues = units;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_unit, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.mUnitCode.setText(mValues.get(position).getUnitCode());
        holder.mUnitName.setText(mValues.get(position).getUnitName());
        holder.mUnitDescription.setText(mValues.get(position).getUnitDescription());
        holder.mUnitLecturer.setText(mValues.get(position).getUnitLecturer());

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    mListener.onListFragmentInteraction(holder.mItem);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final Button mUnitName;
        public final TextView mUnitCode;
        public final TextView mUnitDescription;
        public final TextView mUnitLecturer;
        public CourseUnit mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mUnitName = view.findViewById(R.id.mUnitName);
            mUnitCode = view.findViewById(R.id.mUnitCode);
            mUnitDescription = view.findViewById(R.id.mUnitDescription);
            mUnitLecturer = view.findViewById(R.id.mUnitLecturer);
        }

    }
}
