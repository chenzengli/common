package com.mc.common.mvp.address.bean;

import com.mc.common.base.BaseBean;

import java.util.List;

/**
 * Created by momologo on 2017/11/11.
 *
 * @author momologo
 */

public class Area extends BaseBean {


    private List<AreaListBean> areaList;

    public List<AreaListBean> getAreaList() {
        return areaList;
    }

    public void setAreaList(List<AreaListBean> areaList) {
        this.areaList = areaList;
    }

    public static class AreaListBean {
        /**
         * area_id : 101101
         * attach : null
         * areaSecnonList : [{"area_id":"1011011001","attach":null,"area_name":"合肥市","area_comment":"合肥市","areaThirdList":[{"area_id":"101101100110001","attach":null,"area_name":"瑶海区","area_comment":"瑶海区"},{"area_id":"101101100110002","attach":null,"area_name":"包河区","area_comment":"包河区"},{"area_id":"101101100110003","attach":null,"area_name":"高新区","area_comment":""},{"area_id":"101101100110004","attach":null,"area_name":"蜀山区","area_comment":""},{"area_id":"101101100110005","attach":null,"area_name":"庐阳区","area_comment":""},{"area_id":"101101100110006","attach":null,"area_name":"滨湖新区","area_comment":""},{"area_id":"101101100110007","attach":null,"area_name":"政务区","area_comment":""},{"area_id":"101101100110008","attach":null,"area_name":"经开区","area_comment":""}]},{"area_id":"1011011002","attach":null,"area_name":"芜湖市","area_comment":"芜湖市","areaThirdList":[{"area_id":"101101100210001","attach":null,"area_name":"弋江区","area_comment":""},{"area_id":"101101100210002","attach":null,"area_name":"鸠江区","area_comment":""},{"area_id":"101101100210003","attach":null,"area_name":"镜湖区","area_comment":"镜湖区"},{"area_id":"101101100210004","attach":null,"area_name":"三山区","area_comment":"三山区"},{"area_id":"101101100210005","attach":null,"area_name":"芜湖县","area_comment":"芜湖县"},{"area_id":"101101100210006","attach":null,"area_name":"繁昌县","area_comment":"繁昌县"},{"area_id":"101101100210007","attach":null,"area_name":"南陵县","area_comment":"南陵县"},{"area_id":"101101100210008","attach":null,"area_name":"无为县","area_comment":"无为县"}]},{"area_id":"1011011003","attach":null,"area_name":"蚌埠市","area_comment":"蚌埠市","areaThirdList":[{"area_id":"101101100310001","attach":null,"area_name":"龙子湖","area_comment":"龙子湖"},{"area_id":"101101100310002","attach":null,"area_name":"禹会区","area_comment":"禹会区"},{"area_id":"101101100310003","attach":null,"area_name":"淮上区","area_comment":"淮上区"},{"area_id":"101101100310004","attach":null,"area_name":"怀远县","area_comment":"怀远县"},{"area_id":"101101100310005","attach":null,"area_name":"五河县","area_comment":"五河县"},{"area_id":"101101100310006","attach":null,"area_name":"固镇县","area_comment":"固镇县"}]},{"area_id":"1011011004","attach":null,"area_name":"阜阳市","area_comment":"阜阳市","areaThirdList":[{"area_id":"101101100410001","attach":null,"area_name":"颍州区","area_comment":""},{"area_id":"101101100410002","attach":null,"area_name":"颍泉区","area_comment":""},{"area_id":"101101100410003","attach":null,"area_name":"颍东区","area_comment":""},{"area_id":"101101100410004","attach":null,"area_name":"颍上县","area_comment":""},{"area_id":"101101100410005","attach":null,"area_name":"界首市","area_comment":""},{"area_id":"101101100410006","attach":null,"area_name":"临泉县","area_comment":""},{"area_id":"101101100410007","attach":null,"area_name":"阜南县","area_comment":""},{"area_id":"101101100410008","attach":null,"area_name":"太和县","area_comment":""}]},{"area_id":"1011011005","attach":null,"area_name":"池州市","area_comment":"池州市","areaThirdList":[{"area_id":"101101100510001","attach":null,"area_name":"贵池区","area_comment":""},{"area_id":"101101100510002","attach":null,"area_name":"青阳县","area_comment":""},{"area_id":"101101100510003","attach":null,"area_name":"石台县","area_comment":""},{"area_id":"101101100510004","attach":null,"area_name":"东至县","area_comment":""}]},{"area_id":"1011011006","attach":null,"area_name":"淮南市","area_comment":"","areaThirdList":[{"area_id":"101101100610001","attach":null,"area_name":"大通区","area_comment":""},{"area_id":"101101100610002","attach":null,"area_name":"田家庵区","area_comment":""},{"area_id":"101101100610003","attach":null,"area_name":"谢家集区","area_comment":""},{"area_id":"101101100610004","attach":null,"area_name":"八公山区","area_comment":""},{"area_id":"101101100610005","attach":null,"area_name":"潘集区","area_comment":""},{"area_id":"101101100610006","attach":null,"area_name":"凤台县","area_comment":""},{"area_id":"101101100610007","attach":null,"area_name":"寿县","area_comment":""}]},{"area_id":"1011011007","attach":null,"area_name":"马鞍山市","area_comment":"","areaThirdList":[{"area_id":"101101100710001","attach":null,"area_name":"花山区","area_comment":""},{"area_id":"101101100710002","attach":null,"area_name":"雨山区","area_comment":""},{"area_id":"101101100710003","attach":null,"area_name":"博望区","area_comment":""},{"area_id":"101101100710004","attach":null,"area_name":"含山县","area_comment":""},{"area_id":"101101100710005","attach":null,"area_name":"和县","area_comment":""},{"area_id":"101101100710006","attach":null,"area_name":"当涂县","area_comment":""}]},{"area_id":"1011011008","attach":null,"area_name":"淮北市","area_comment":"","areaThirdList":[{"area_id":"101101100810001","attach":null,"area_name":"相山区","area_comment":""},{"area_id":"101101100810002","attach":null,"area_name":"杜集区","area_comment":""},{"area_id":"101101100810003","attach":null,"area_name":"烈山区","area_comment":""},{"area_id":"101101100810004","attach":null,"area_name":"濉溪县","area_comment":""}]},{"area_id":"1011011009","attach":null,"area_name":"铜陵市","area_comment":"","areaThirdList":[{"area_id":"101101100910001","attach":null,"area_name":"铜官区","area_comment":""},{"area_id":"101101100910002","attach":null,"area_name":"郊区","area_comment":""},{"area_id":"101101100910003","attach":null,"area_name":"义安区","area_comment":""},{"area_id":"101101100910004","attach":null,"area_name":"枞阳县","area_comment":""}]},{"area_id":"1011011010","attach":null,"area_name":"安庆市","area_comment":"","areaThirdList":[{"area_id":"101101101010001","attach":null,"area_name":"迎江区","area_comment":""},{"area_id":"101101101010002","attach":null,"area_name":"大观区","area_comment":""},{"area_id":"101101101010003","attach":null,"area_name":"宜秀区","area_comment":""},{"area_id":"101101101010004","attach":null,"area_name":"怀宁县","area_comment":""},{"area_id":"101101101010005","attach":null,"area_name":"桐城市","area_comment":""},{"area_id":"101101101010006","attach":null,"area_name":"潜山县","area_comment":""},{"area_id":"101101101010007","attach":null,"area_name":"太湖县","area_comment":""},{"area_id":"101101101010008","attach":null,"area_name":"宿松县","area_comment":""},{"area_id":"101101101010009","attach":null,"area_name":"望江县","area_comment":""},{"area_id":"101101101010010","attach":null,"area_name":"岳西县","area_comment":""}]},{"area_id":"1011011011","attach":null,"area_name":"黄山市","area_comment":"","areaThirdList":[{"area_id":"101101101110001","attach":null,"area_name":"屯溪区","area_comment":""},{"area_id":"101101101110002","attach":null,"area_name":"黄山区","area_comment":""},{"area_id":"101101101110003","attach":null,"area_name":"徽州区","area_comment":""},{"area_id":"101101101110004","attach":null,"area_name":"歙县","area_comment":""},{"area_id":"101101101110005","attach":null,"area_name":"休宁县","area_comment":""},{"area_id":"101101101110006","attach":null,"area_name":"黟县","area_comment":""},{"area_id":"101101101110007","attach":null,"area_name":"祁门县","area_comment":""}]},{"area_id":"1011011012","attach":null,"area_name":"宿州市","area_comment":"","areaThirdList":[{"area_id":"101101101210001","attach":null,"area_name":"埇桥区","area_comment":""},{"area_id":"101101101210002","attach":null,"area_name":"萧县","area_comment":""},{"area_id":"101101101210003","attach":null,"area_name":"砀山县","area_comment":""},{"area_id":"101101101210004","attach":null,"area_name":"灵璧县","area_comment":""},{"area_id":"101101101210005","attach":null,"area_name":"泗县","area_comment":""}]},{"area_id":"1011011013","attach":null,"area_name":"滁州市","area_comment":"","areaThirdList":[{"area_id":"101101101310001","attach":null,"area_name":"琅琊区","area_comment":""},{"area_id":"101101101310002","attach":null,"area_name":"南谯区","area_comment":""},{"area_id":"101101101310003","attach":null,"area_name":"天长市","area_comment":""},{"area_id":"101101101310004","attach":null,"area_name":"明光市","area_comment":""},{"area_id":"101101101310005","attach":null,"area_name":"全椒县","area_comment":""},{"area_id":"101101101310006","attach":null,"area_name":"来安县","area_comment":""},{"area_id":"101101101310007","attach":null,"area_name":"凤阳县","area_comment":""},{"area_id":"101101101310008","attach":null,"area_name":"定远县","area_comment":""}]},{"area_id":"1011011014","attach":null,"area_name":"六安市","area_comment":"","areaThirdList":[{"area_id":"101101101410001","attach":null,"area_name":"金安区","area_comment":""},{"area_id":"101101101410002","attach":null,"area_name":"裕安区","area_comment":""},{"area_id":"101101101410003","attach":null,"area_name":"叶集区","area_comment":""},{"area_id":"101101101410004","attach":null,"area_name":"霍邱县","area_comment":""},{"area_id":"101101101410005","attach":null,"area_name":"霍山县","area_comment":""},{"area_id":"101101101410006","attach":null,"area_name":"金寨县","area_comment":""},{"area_id":"101101101410007","attach":null,"area_name":"舒城县","area_comment":""}]},{"area_id":"1011011015","attach":null,"area_name":"宣城市","area_comment":"","areaThirdList":[{"area_id":"101101101510001","attach":null,"area_name":"宣州区","area_comment":""},{"area_id":"101101101510002","attach":null,"area_name":"郎溪县","area_comment":""},{"area_id":"101101101510003","attach":null,"area_name":"广德县","area_comment":""},{"area_id":"101101101510004","attach":null,"area_name":"宁国市","area_comment":""},{"area_id":"101101101510005","attach":null,"area_name":"泾县","area_comment":""},{"area_id":"101101101510006","attach":null,"area_name":"绩溪县","area_comment":""},{"area_id":"101101101510007","attach":null,"area_name":"旌德县","area_comment":""}]},{"area_id":"1011011016","attach":null,"area_name":"亳州市","area_comment":"","areaThirdList":[{"area_id":"101101101610001","attach":null,"area_name":"谯城区","area_comment":""},{"area_id":"101101101610002","attach":null,"area_name":"蒙城县","area_comment":""},{"area_id":"101101101610003","attach":null,"area_name":"涡阳县","area_comment":""},{"area_id":"101101101610004","attach":null,"area_name":"利辛县","area_comment":""}]}]
         * area_name : 安徽省
         * area_comment : 安徽省
         */

        private String area_id;
        private String attach;
        private String area_name;
        private String area_comment;
        private List<AreaSecnonListBean> areaSecnonList;

        public String getArea_id() {
            return area_id;
        }

        public void setArea_id(String area_id) {
            this.area_id = area_id;
        }

        public String getAttach() {
            return attach;
        }

        public void setAttach(String attach) {
            this.attach = attach;
        }

        public String getArea_name() {
            return area_name;
        }

        public void setArea_name(String area_name) {
            this.area_name = area_name;
        }

        public String getArea_comment() {
            return area_comment;
        }

        public void setArea_comment(String area_comment) {
            this.area_comment = area_comment;
        }

        public List<AreaSecnonListBean> getAreaSecnonList() {
            return areaSecnonList;
        }

        public void setAreaSecnonList(List<AreaSecnonListBean> areaSecnonList) {
            this.areaSecnonList = areaSecnonList;
        }

        public static class AreaSecnonListBean {
            /**
             * area_id : 1011011001
             * attach : null
             * area_name : 合肥市
             * area_comment : 合肥市
             * areaThirdList : [{"area_id":"101101100110001","attach":null,"area_name":"瑶海区","area_comment":"瑶海区"},{"area_id":"101101100110002","attach":null,"area_name":"包河区","area_comment":"包河区"},{"area_id":"101101100110003","attach":null,"area_name":"高新区","area_comment":""},{"area_id":"101101100110004","attach":null,"area_name":"蜀山区","area_comment":""},{"area_id":"101101100110005","attach":null,"area_name":"庐阳区","area_comment":""},{"area_id":"101101100110006","attach":null,"area_name":"滨湖新区","area_comment":""},{"area_id":"101101100110007","attach":null,"area_name":"政务区","area_comment":""},{"area_id":"101101100110008","attach":null,"area_name":"经开区","area_comment":""}]
             */

            private String area_id;
            private String attach;
            private String area_name;
            private String area_comment;
            private List<AreaThirdListBean> areaThirdList;

            public String getArea_id() {
                return area_id;
            }

            public void setArea_id(String area_id) {
                this.area_id = area_id;
            }

            public String getAttach() {
                return attach;
            }

            public void setAttach(String attach) {
                this.attach = attach;
            }

            public String getArea_name() {
                return area_name;
            }

            public void setArea_name(String area_name) {
                this.area_name = area_name;
            }

            public String getArea_comment() {
                return area_comment;
            }

            public void setArea_comment(String area_comment) {
                this.area_comment = area_comment;
            }

            public List<AreaThirdListBean> getAreaThirdList() {
                return areaThirdList;
            }

            public void setAreaThirdList(List<AreaThirdListBean> areaThirdList) {
                this.areaThirdList = areaThirdList;
            }

            public static class AreaThirdListBean {
                /**
                 * area_id : 101101100110001
                 * attach : null
                 * area_name : 瑶海区
                 * area_comment : 瑶海区
                 */

                private String area_id;
                private String attach;
                private String area_name;
                private String area_comment;

                public String getArea_id() {
                    return area_id;
                }

                public void setArea_id(String area_id) {
                    this.area_id = area_id;
                }

                public String getAttach() {
                    return attach;
                }

                public void setAttach(String attach) {
                    this.attach = attach;
                }

                public String getArea_name() {
                    return area_name;
                }

                public void setArea_name(String area_name) {
                    this.area_name = area_name;
                }

                public String getArea_comment() {
                    return area_comment;
                }

                public void setArea_comment(String area_comment) {
                    this.area_comment = area_comment;
                }
            }
        }
    }
}
