package com.ihc.tree_knowledge;

import java.util.ArrayList;
import java.util.List;

public class DummyDB {

    private static DummyDB instance;

    private List<Employee> companyEmployees;
    private List<Knowledge> companyKnowledges;
    private Employee lastFoundEmployee;
    private List<Certification> companyCertifications;
    private Employee loggedUser;

    public static DummyDB getInstance(){
        if(instance == null){
            instance = new DummyDB();
            instance.initData();
        }

        return instance;
    }

    private DummyDB() {
        this.companyEmployees = new ArrayList<>();
        this.companyKnowledges = new ArrayList<>();
        this.companyCertifications = new ArrayList<>();
    }

    public void addEmployee(Employee employee) {
        companyEmployees.add(employee);
    }

    public Employee findEmployeeByEmail(String email) {
        for (Employee e : companyEmployees) {
            if (e.getEmail().equalsIgnoreCase(email)) {
                this.lastFoundEmployee = e;
                return e;
            }
        }
        return null;
    }
    public Employee findEmployeeByName(String name) {
        for (Employee e : companyEmployees) {
            if (e.getName().equalsIgnoreCase(name)) {
                this.lastFoundEmployee = e;
                return e;
            }
        }
        return null;
    }


    public void loginEmployee(String email) {
        if (this.lastFoundEmployee != null && this.lastFoundEmployee.getEmail().equalsIgnoreCase(email)) {
            this.lastFoundEmployee.login();
            this.loggedUser = this.lastFoundEmployee;
        } else {
            for (Employee e : companyEmployees) {
                if (e.getEmail().equalsIgnoreCase(email)) {
                    this.lastFoundEmployee = e;
                    e.login();
                    this.loggedUser = e;
                }
            }
        }
    }

    public String getLoggedEmployeeName() {
        return loggedUser.getName();
    }

    public Employee getLoggedUser(){
        return loggedUser;
    }

    public Employee findEmployee(String email, String password) {
        for (Employee e : companyEmployees) {
            if (e.getEmail().equalsIgnoreCase(email) && e.getPassword().equals(password)) {
                return e;
            }
        }
        return null;
    }

    public void addKnowledgeToRoot(String nome) {
        Knowledge k = new Knowledge(this.companyKnowledges.size() + 1, nome, Knowledge.ROOT);
        this.companyKnowledges.add(k);
    }

    public Knowledge findKnowlegde(String nome) {
        for (Knowledge k : companyKnowledges) {
            if (k.getName().equals(nome)) {
                return k;
            }
        }

        return null;
    }

    public void addCertification(Certification certification) {
        companyCertifications.add(certification);
    }

    private void initData(){
        Employee e1 = new Employee(1, "Diego Alves", "Desenvolvedor Java",
                "diego.alves@acme.com", "1234", "123456", RoleEnum.USER);

        Employee e2 = new Employee(2, "Pedro Santana", "Gerente de projetos",
                "pedro.santana@acme.com", "1234", "123456", RoleEnum.MANAGER);

        Employee e3 = new Employee(3, "Rodrigo Silva", "Desenvolvedor Java",
                "rodrigo.silva@acme.com", "1234", "123456", RoleEnum.USER);

        Employee e4 = new Employee(4, "Mariana Garcia", "Coordenadora",
                "mariana.garcia@acme.com", "1234", "123456", RoleEnum.HR);

        Employee e5 = new Employee(5, "Roger Flores", "Desenvolvedor Python",
                "roger.flores@acme.com", "1234", "123456", RoleEnum.USER);

        companyEmployees.add(e1);
        companyEmployees.add(e2);
        companyEmployees.add(e3);
        companyEmployees.add(e4);
        companyEmployees.add(e5);

        Knowledge k1 = Knowledge.ROOT;

        Knowledge k2 = new Knowledge(2, "Lógica de Programação", k1);
        Knowledge k3 = new Knowledge(3, "Microsoft Windows", k1);

        Knowledge k4 = new Knowledge(4, "Java", k2);
        Knowledge k5 = new Knowledge(5, "Python", k2);

        Knowledge k6 = new Knowledge(6, "Word 2013", k3);
        Knowledge k7 = new Knowledge(7, "Excel 2013", k3);

        Knowledge k8 = new Knowledge(8, "JavaFX", k4);
        Knowledge k9 = new Knowledge(9, "JPA", k4);
        Knowledge k10 = new Knowledge(10, "JAX-RS", k4);

        Knowledge k11 = new Knowledge(11, "NumPy", k5);
        Knowledge k12 = new Knowledge(12, "PyTorch", k5);

        companyKnowledges.add(k1);
        companyKnowledges.add(k2);
        companyKnowledges.add(k3);
        companyKnowledges.add(k4);
        companyKnowledges.add(k5);
        companyKnowledges.add(k6);
        companyKnowledges.add(k7);
        companyKnowledges.add(k8);
        companyKnowledges.add(k9);
        companyKnowledges.add(k10);
        companyKnowledges.add(k11);
        companyKnowledges.add(k12);

        e1.addKnowledge(k4);
        e1.addKnowledge(k8);
        e1.addKnowledge(k9);
        e1.addKnowledge(k10);
        e1.addKnowledge(k11);
        e1.addKnowledge(k12);

        e2.addKnowledge(k4);
        e2.addKnowledge(k6);
        e2.addKnowledge(k7);

        e3.addKnowledge(k4);
        e3.addKnowledge(k9);
        e3.addKnowledge(k10);
        e3.addKnowledge(k6);

        e4.addKnowledge(k6);
        e4.addKnowledge(k7);

        e5.addKnowledge(k4);
        e5.addKnowledge(k5);
        e5.addKnowledge(k11);
        e5.addKnowledge(k12);
        e5.addKnowledge(k6);
        e5.addKnowledge(k7);

        String[][] certificationArray = {
                {"C#", "Diego Alves", "18/10/2017", "PENDENTE", "C# Certificado XPTO!"},
                {"C++", "Diego Alves", "31/10/2017", "PENDENTE", "C++ Certificado XPTO!"},
                {"PMBOK", "Pedro Santana", "07/09/2017", "APROVADO", "PMBOK Certificado XPTO!"},
                {"Mandarim Básico", "Diego Alves", "01/08/2017", "REPROVADO", "Beginner Chinese Mandarin Certificate!"},
                {"C++", "Rodrigo Silva", "26/09/2017", "APROVADO", "C++ 2017 Certificate XPTO!"},
                {"Estruturas de Dados", "Rodrigo Silva", "31/06/2017", "REPROVADO", "Estruturas de Dados Certificado!"},
                {"SQL Server 2013", "Diego Alves", "03/09/2017", "APROVADO", "Microsoft SQL Server 2013 Certificate XPTO!"},
                {"Machine Learning", "Mariana Garcia", "02/10/2017", "PENDENTE", "Machine Learning Certificado XPTO!"},
                {"JavaFX", "Mariana Garcia", "18/07/2017", "PENDENTE", "JavaFX Certificado XPTO!"},
        };

        for (String[] aCertificationList : certificationArray) {
            Certification certification = new Certification(aCertificationList[0], aCertificationList[1],
                    aCertificationList[2], aCertificationList[3], aCertificationList[4]);
            this.companyCertifications.add(certification);
        }
    }

    public List<Employee> getCompanyEmployees() {
        return companyEmployees;
    }

    public List<Certification> getCompanyCertifications() { return companyCertifications; }

    public Knowledge getCompanyRoot() {
        return Knowledge.ROOT;
    }

    public boolean handleApprovedCertificationInCommonCase(String knowledge, String userName) {
        Knowledge k = findKnowlegde(knowledge);

        if (k != null) {
            Employee the_emp = null;
            for (Employee e : companyEmployees) {
                if (e.getName().equalsIgnoreCase(userName)) {
                    the_emp = e;
                    break;
                }
            }

            if (the_emp != null) {
                the_emp.addKnowledge(k);
            }

            return true;
        }

        return false;
    }

    public boolean approveCertification(String knowledge, String userName, String date, String certification) {
        Certification the_certification = null;

        for (Certification cert : companyCertifications) {
            if (cert.getKnowledge().equals(knowledge) && cert.getUserName().equals(userName) &&
                    cert.getDate().equals(date) && cert.getCertification().equals(certification)) {
                the_certification = cert;
                break;
            }
        }

        if (the_certification != null) {
            the_certification.setStatus("APROVADO");
            return true;
        }

        return false;
    }

    public boolean disapproveCertification(String knowledge, String userName, String date, String certification) {
        Certification the_certification = null;

        for (Certification cert : companyCertifications) {
            if (cert.getKnowledge().equals(knowledge) && cert.getUserName().equals(userName) &&
                    cert.getDate().equals(date) && cert.getCertification().equals(certification)) {
                the_certification = cert;
                break;
            }
        }

        if (the_certification != null) {
            the_certification.setStatus("REPROVADO");
            return true;
        }

        return false;
    }

    public List<String[]> getEmployeeList() {
        List<String[]> employeeList = new ArrayList<>();
        for (Employee e : companyEmployees) {
            String[] stringArray = {e.getName(), e.getRole()};
            employeeList.add(stringArray);
        }

        return employeeList;
    }

    public List<String[]> getEmployeeListByKnowledge(String knowledge) {
        List<String[]> employeeList = new ArrayList<>();
        for (Employee e : companyEmployees) {
            if (e.hasAKnowledge(knowledge)) {
                String[] stringArray = {e.getName(), e.getRole()};
                employeeList.add(stringArray);
            }
        }

        return employeeList;
    }
}
