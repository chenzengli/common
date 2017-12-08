package com.mc.common.mvp.address.bean;

import android.os.Parcel;
import android.os.Parcelable;

import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.mc.common.base.BaseBean;
import com.mc.common.mvp.address.view.AddressAdapter;

import java.util.List;

/**
 * Created by momologo on 2017/9/27.
 *
 * @author momologo
 */

public class Address extends BaseBean {

    /**
     * totalResult : 2
     * addrList : [{"location_addr_id":"101101100110001","location_addr":"安徽省合肥市瑶海区","name":"陈增立","detail_addr":"长淮街道胜利路196号","user_id":"88b5058252a04596b42e39790df67bfc","add_time":1510818519000,"addr_id":98,"addr_state":"0","mobile":"17756027656"},{"location_addr_id":"101101100410007","location_addr":"安徽省阜阳市阜南县","name":"陈增立","detail_addr":"龙王爷韩营村庞圩组51号","user_id":"88b5058252a04596b42e39790df67bfc","add_time":1510819001000,"addr_id":99,"addr_state":"1","mobile":"17756027656"}]
     * showCount : 10
     * currentPage : 1
     * totalPage : 1
     */

    private int totalResult;
    private int showCount;
    private int currentPage;
    private int totalPage;
    private List<AddrListBean> addrList;

    public int getTotalResult() {
        return totalResult;
    }

    public void setTotalResult(int totalResult) {
        this.totalResult = totalResult;
    }

    public int getShowCount() {
        return showCount;
    }

    public void setShowCount(int showCount) {
        this.showCount = showCount;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public List<AddrListBean> getAddrList() {
        return addrList;
    }

    public void setAddrList(List<AddrListBean> addrList) {
        this.addrList = addrList;
    }

    public static class AddrListBean implements Parcelable, MultiItemEntity {

        public static final Parcelable.Creator<AddrListBean> CREATOR = new Parcelable.Creator<AddrListBean>() {
            @Override
            public AddrListBean createFromParcel(Parcel source) {
                return new AddrListBean(source);
            }

            @Override
            public AddrListBean[] newArray(int size) {
                return new AddrListBean[size];
            }
        };
        /**
         * location_addr_id : 101101100110001
         * location_addr : 安徽省合肥市瑶海区
         * name : 陈增立
         * detail_addr : 长淮街道胜利路196号
         * user_id : 88b5058252a04596b42e39790df67bfc
         * add_time : 1510818519000
         * addr_id : 98
         * addr_state : 0
         * mobile : 17756027656
         */

        private String location_addr_id;
        private String location_addr;
        private String name;
        private String detail_addr;
        private String user_id;
        private long add_time;
        private int addr_id;
        private String addr_state;
        private String mobile;

        public AddrListBean() {
        }

        protected AddrListBean(Parcel in) {
            this.location_addr_id = in.readString();
            this.location_addr = in.readString();
            this.name = in.readString();
            this.detail_addr = in.readString();
            this.user_id = in.readString();
            this.add_time = in.readLong();
            this.addr_id = in.readInt();
            this.addr_state = in.readString();
            this.mobile = in.readString();
        }

        public String getLocation_addr_id() {
            return location_addr_id;
        }

        public void setLocation_addr_id(String location_addr_id) {
            this.location_addr_id = location_addr_id;
        }

        public String getLocation_addr() {
            return location_addr;
        }

        public void setLocation_addr(String location_addr) {
            this.location_addr = location_addr;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDetail_addr() {
            return detail_addr;
        }

        public void setDetail_addr(String detail_addr) {
            this.detail_addr = detail_addr;
        }

        public String getUser_id() {
            return user_id;
        }

        public void setUser_id(String user_id) {
            this.user_id = user_id;
        }

        public long getAdd_time() {
            return add_time;
        }

        public void setAdd_time(long add_time) {
            this.add_time = add_time;
        }

        public int getAddr_id() {
            return addr_id;
        }

        public void setAddr_id(int addr_id) {
            this.addr_id = addr_id;
        }

        public String getAddr_state() {
            return addr_state;
        }

        public void setAddr_state(String addr_state) {
            this.addr_state = addr_state;
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(this.location_addr_id);
            dest.writeString(this.location_addr);
            dest.writeString(this.name);
            dest.writeString(this.detail_addr);
            dest.writeString(this.user_id);
            dest.writeLong(this.add_time);
            dest.writeInt(this.addr_id);
            dest.writeString(this.addr_state);
            dest.writeString(this.mobile);
        }

        @Override
        public int getItemType() {
            return AddressAdapter.TYPE_ADDRESS;
        }
    }
}
