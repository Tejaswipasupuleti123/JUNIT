package com.example.hrmanagementtejaswi;public class Worker {


    public Worker(int empid, String emp, String empwd, double salary) {
    }

    public class worker
    {
        private int empid;
        private String emp;
        private String empwd;
        private double salary;

        public worker(int empid, String emp, String empwd, double salary) {
            this.empid = empid;
            this.emp = emp;
            this.empwd = empwd;
            this.salary = salary;
        }

        public int getEmpid() {
            return empid;
        }

        public void setEmpid(int empid) {
            this.empid = empid;
        }

        public String getEmp() {
            return emp;
        }

        public void setEmp(String emp) {
            this.emp = emp;
        }

        public String getEmpwd() {
            return empwd;
        }

        public void setEmpwd(String empwd) {
            this.empwd = empwd;
        }

        public double getSalary() {
            return salary;
        }

        public void setSalary(double salary) {
            this.salary = salary;
        }
    }
}
