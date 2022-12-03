package com.example.demo.data;

import java.util.*;

public class DishOrderList {

    public DishOrderList() {





    }




//    public class BusGarage {
//        private List<Bus> buses = new LinkedList<>();
//
//        void addBus(Bus newBus){
//            buses.add(newBus);
//        }
//
//        void printBusFoiDriver(String fioDriv){
//            for (Bus tmpBus : buses){
//                if (tmpBus.getFioDriver().equals(fioDriv)){
//                    System.out.println(tmpBus);
//                    return;
//                }
//            }
//            System.out.println("Нет автобуса с водителем \'" + fioDriv + '\'');
//        }
//
//        public static void main(String[] args) {
//            BusGarage baza = new BusGarage();
//            baza.addBus(new Bus("Иванов И.И."));
//            baza.addBus(new Bus("Петров П.П.","B027EE",91));
//            baza.addBus(new Bus("Зиганшин Р.Г.","O465KO",15));
//
//            baza.printBusFoiDriver("Зиганшин Р.Г.");
//            baza.printBusFoiDriver("Сивер П.И.");
//        }
//
//    }
//    //####
//    class Bus {
//        private String fioDriver;
//        private String busNumber;
//        private int route;
//        private String priznak = "";
//
//        public Bus(String fioDriver, String busNumber, int route) {
//            this.fioDriver = fioDriver;
//            this.busNumber = busNumber;
//            this.route = route;
//        }
//
//        public Bus(String fioDriver) {
//            this(fioDriver,"Non",-1);
//        }
//
//        public String getPriznak() {
//            return priznak;
//        }
//
//        public void setPriznak(String priznak) {
//            this.priznak = priznak;
//        }
//
//        public String getFioDriver() {
//            return fioDriver;
//        }
//
//        public void setFioDriver(String fioDriver) {
//            this.fioDriver = fioDriver;
//        }
//
//        public String getBusNumber() {
//            return busNumber;
//        }
//
//        public void setBusNumber(String busNumber) {
//            this.busNumber = busNumber;
//        }
//
//        public int getRoute() {
//            return route;
//        }
//
//        public void setRoute(int route) {
//            this.route = route;
//        }
//
//        @Override
//        public String toString() {
//            return "Bus{" +
//                    "fioDriver='" + fioDriver + '\'' +
//                    ", busNumber='" + busNumber + '\'' +
//                    ", route=" + route +
//                    ", priznak='" + priznak + '\'' +
//                    '}';
//        }
//    }


}
