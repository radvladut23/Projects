package presentation;
import dao.OperatiiClient;
import dao.OperatiiOrder;
import dao.OperatiiProduct;
import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame {
    private JPanel clienti;
    private JPanel produse;
    private JPanel comenzi;
    private JTabbedPane panou;
    private JLabel titlu;
    private JLabel idcl;
    private JLabel numecl;
    private JLabel prenumecl;
    private JLabel adresacl;
    private JTable tableCl;
    private JTextField tid;
    private JTextField tnume;
    private JTextField tprenume;
    private JTextField tadresa;
    private JLabel lid;
    private JLabel lnume;
    private JLabel lprenume;
    private JLabel ladresa;
    private JButton badd;
    private JButton bdel;
    private JButton bupd;
    private JButton refresh;
    private JLabel idprod;
    private JLabel numeprod;
    private JLabel cantit;
    private JLabel pret;
    private JTable tableProd;
    private JTextField tidprod;
    private JTextField tnumeprod;
    private JTextField tcantit;
    private JTextField tpret;
    private JLabel lidprod;
    private JLabel lnumeprod;
    private JLabel lcantit;
    private JLabel lpret;
    private JButton badd2;
    private JButton bdel2;
    private JButton bupd2;
    private JButton refresh2;
    private JLabel idord;
    private JLabel idclo;
    private JLabel idprodo;
    private JLabel cantito;
    private JTable tableOrd;
    private JTextField tidord;
    private JTextField tidclo;
    private JTextField tidprodo;
    private JTextField tcantito;
    private JLabel lidord;
    private JLabel lidclo;
    private JLabel lidprodo;
    private JLabel lcantito;
    private JButton badd3;
    private JButton refresh3;

    public Frame() {
        this.setLayout(null);
        this.setBounds(0, 0, 1600, 850);
        this.getContentPane().setBackground(new Color(179, 255, 217));
        this.setTitle("Order Management");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        clienti = new JPanel();
        clienti.setLayout(null);
        clienti.setBackground(new Color(74, 149, 150));

        produse = new JPanel();
        produse.setLayout(null);
        produse.setBackground(new Color(74, 149, 150));

        comenzi = new JPanel();
        comenzi.setLayout(null);
        comenzi.setBackground(new Color(74, 149, 150));

        panou = new JTabbedPane();
        panou.setBounds(-10, 80, 1600, 820);
        panou.setBackground(new Color(252, 242, 206));
        panou.add("Clients", clienti);
        panou.add("Products", produse);
        panou.add("Orders", comenzi);

        titlu=new JLabel("Order Management");
        titlu.setBounds(630,30,400,40);
        titlu.setFont(new Font("Georgia", Font.BOLD,30));
        tableCl=new JTable();
        tableCl= OperatiiClient.showTableClients();
        tableCl.setBounds(485,450,600,200);
        clienti.add(tableCl);
        idcl=new JLabel("Client ID:");
        idcl.setBounds(485,380,100,100);
        idcl.setFont(new Font("Georgia", Font.BOLD,15));
        clienti.add(idcl);
        numecl=new JLabel("Last name:");
        numecl.setBounds(635,380,100,100);
        numecl.setFont(new Font("Georgia", Font.BOLD,15));
        clienti.add(numecl);
        prenumecl=new JLabel("First name:");
        prenumecl.setBounds(785,380,100,100);
        prenumecl.setFont(new Font("Georgia", Font.BOLD,15));
        clienti.add(prenumecl);
        adresacl=new JLabel("Adress:");
        adresacl.setBounds(935,380,100,100);
        adresacl.setFont(new Font("Georgia", Font.BOLD,15));
        clienti.add(adresacl);
        tid=new JTextField();
        tid.setBounds(100,80,200,30);
        clienti.add(tid);
        lid=new JLabel("Client ID:");
        lid.setFont(new Font("Georgia", Font.BOLD,15));
        lid.setBounds(102,50,200,30);
        clienti.add(lid);
        tnume=new JTextField();
        tnume.setBounds(100,150,200,30);
        clienti.add(tnume);
        lnume=new JLabel("Last name:");
        lnume.setFont(new Font("Georgia", Font.BOLD,15));
        lnume.setBounds(102,120,200,30);
        clienti.add(lnume);
        tprenume=new JTextField();
        tprenume.setBounds(100,220,200,30);
        clienti.add(tprenume);
        lprenume=new JLabel("First name:");
        lprenume.setFont(new Font("Georgia", Font.BOLD,15));
        lprenume.setBounds(102,190,200,30);
        clienti.add(lprenume);
        tadresa=new JTextField();
        tadresa.setBounds(100,290,200,30);
        clienti.add(tadresa);
        ladresa=new JLabel("Adress:");
        ladresa.setFont(new Font("Georgia", Font.BOLD,15));
        ladresa.setBounds(102,260,200,30);
        clienti.add(ladresa);
        badd=new JButton("Add client");
        badd.setBounds(500,180,150,50);
        clienti.add(badd);
        bdel=new JButton("Delete client");
        bdel.setBounds(700,180,150,50);
        clienti.add(bdel);
        bupd=new JButton("Update client");
        bupd.setBounds(900,180,150,50);
        clienti.add(bupd);
        refresh=new JButton("Refresh");
        refresh.setBounds(1250,500,150,70);
        refresh.setBackground(new Color(76, 230, 0));
        clienti.add(refresh);
        tableProd=new JTable();
        tableProd= OperatiiProduct.showTableProducts();
        tableProd.setBounds(485,450,600,200);
        produse.add(tableProd);
        idprod=new JLabel("Product ID:");
        idprod.setBounds(485,380,100,100);
        idprod.setFont(new Font("Georgia", Font.BOLD,15));
        produse.add(idprod);
        numeprod=new JLabel("Name:");
        numeprod.setBounds(635,380,100,100);
        numeprod.setFont(new Font("Georgia", Font.BOLD,15));
        produse.add(numeprod);
        cantit=new JLabel("Amount:");
        cantit.setBounds(785,380,100,100);
        cantit.setFont(new Font("Georgia", Font.BOLD,15));
        produse.add(cantit);        pret=new JLabel("Price:");
        pret.setBounds(935,380,100,100);
        pret.setFont(new Font("Georgia", Font.BOLD,15));
        produse.add(pret);
        tidprod=new JTextField();
        tidprod.setBounds(100,80,200,30);
        produse.add(tidprod);
        lidprod=new JLabel("Product ID:");
        lidprod.setFont(new Font("Georgia", Font.BOLD,15));
        lidprod.setBounds(102,50,200,30);
        produse.add(lidprod);
        tnumeprod=new JTextField();
        tnumeprod.setBounds(100,150,200,30);
        produse.add(tnumeprod);
        lnumeprod=new JLabel("Name:");
        lnumeprod.setFont(new Font("Georgia", Font.BOLD,15));
        lnumeprod.setBounds(102,120,200,30);
        produse.add(lnumeprod);
        tcantit=new JTextField();
        tcantit.setBounds(100,220,200,30);
        produse.add(tcantit);
        lcantit=new JLabel("Amount:");
        lcantit.setFont(new Font("Georgia", Font.BOLD,15));
        lcantit.setBounds(102,190,200,30);
        produse.add(lcantit);
        tpret=new JTextField();
        tpret.setBounds(100,290,200,30);
        produse.add(tpret);
        lpret=new JLabel("Price:");
        lpret.setFont(new Font("Georgia", Font.BOLD,15));
        lpret.setBounds(102,260,200,30);
        produse.add(lpret);
        badd2=new JButton("Add product");
        badd2.setBounds(500,180,150,50);
        produse.add(badd2);
        bdel2=new JButton("Delete product");
        bdel2.setBounds(700,180,150,50);
        produse.add(bdel2);
        bupd2=new JButton("Update product");
        bupd2.setBounds(900,180,150,50);
        produse.add(bupd2);
        refresh2=new JButton("Refresh");
        refresh2.setBounds(1250,500,150,70);
        refresh2.setBackground(new Color(76, 230, 0));
        produse.add(refresh2);
        tableOrd=new JTable();
        tableOrd= OperatiiOrder.showTableOrders();
        tableOrd.setBounds(485,450,600,200);
        comenzi.add(tableOrd);
        idord=new JLabel("Order ID:");
        idord.setBounds(485,380,100,100);
        idord.setFont(new Font("Georgia", Font.BOLD,15));
        comenzi.add(idord);
        idclo=new JLabel("Client ID:");
        idclo.setBounds(635,380,100,100);
        idclo.setFont(new Font("Georgia", Font.BOLD,15));
        comenzi.add(idclo);
        idprodo=new JLabel("Product ID:");
        idprodo.setBounds(785,380,100,100);
        idprodo.setFont(new Font("Georgia", Font.BOLD,15));
        comenzi.add(idprodo);
        cantito=new JLabel("Amount:");
        cantito.setBounds(935,380,100,100);
        cantito.setFont(new Font("Georgia", Font.BOLD,15));
        comenzi.add(cantito);
        tidord=new JTextField();
        tidord.setBounds(100,80,200,30);
        comenzi.add(tidord);
        lidord=new JLabel("Order ID:");
        lidord.setFont(new Font("Georgia", Font.BOLD,15));
        lidord.setBounds(102,50,200,30);
        comenzi.add(lidord);
        tidclo=new JTextField();
        tidclo.setBounds(100,150,200,30);
        comenzi.add(tidclo);
        lidclo=new JLabel("Client ID:");
        lidclo.setFont(new Font("Georgia", Font.BOLD,15));
        lidclo.setBounds(102,120,200,30);
        comenzi.add(lidclo);
        tidprodo=new JTextField();
        tidprodo.setBounds(100,220,200,30);
        comenzi.add(tidprodo);
        lidprodo=new JLabel("Product ID:");
        lidprodo.setFont(new Font("Georgia", Font.BOLD,15));
        lidprodo.setBounds(102,190,200,30);
        comenzi.add(lidprodo);
        tcantito=new JTextField();
        tcantito.setBounds(100,290,200,30);
        comenzi.add(tcantito);
        lcantito=new JLabel("Amount:");
        lcantito.setFont(new Font("Georgia", Font.BOLD,15));
        lcantito.setBounds(102,260,200,30);
        comenzi.add(lcantito);
        badd3=new JButton("Add order");
        badd3.setBounds(500,180,150,50);
        comenzi.add(badd3);
        refresh3=new JButton("Refresh");
        refresh3.setBounds(1250,500,150,70);
        refresh3.setBackground(new Color(76, 230, 0));
        comenzi.add(refresh3);
        this.add(titlu);
        this.add(panou);
    }
    public JTextField getTid() {  return tid;    }
    public void setTid(JTextField tid) {   this.tid = tid;   }
    public JTextField getTnume() {    return tnume;   }
    public void setTnume(JTextField tnume) {    this.tnume = tnume;   }
    public JTextField getTprenume() {    return tprenume;  }
    public void setTprenume(JTextField tprenume) {   this.tprenume = tprenume;   }
    public JTextField getTadresa() {   return tadresa;   }
    public void setTadresa(JTextField tadresa) {   this.tadresa = tadresa;   }
    public JButton getBadd() {   return badd;  }
    public void setBadd(JButton badd) {   this.badd = badd;  }
    public JButton getBdel() {    return bdel;  }
    public void setBdel(JButton bdel) {     this.bdel = bdel;  }
    public JButton getBupd() {    return bupd;  }
    public void setBupd(JButton bupd) {   this.bupd = bupd;  }
    public JButton getRefresh() {    return refresh;  }
    public void setRefresh(JButton refresh) {   this.refresh = refresh;  }
    public JTextField getTidprod() {    return tidprod;  }
    public void setTidprod(JTextField tidprod) {    this.tidprod = tidprod;  }
    public JTextField getTnumeprod() {   return tnumeprod;  }
    public void setTnumeprod(JTextField tnumeprod) {    this.tnumeprod = tnumeprod;  }
    public JTextField getTcantit() {    return tcantit;  }
    public void setTcantit(JTextField tcantit) {   this.tcantit = tcantit;  }
    public JTextField getTpret() {    return tpret;  }
    public void setTpret(JTextField tpret) {    this.tpret = tpret;   }
    public JButton getBadd2() {     return badd2;  }
    public void setBadd2(JButton badd2) {    this.badd2 = badd2; }
    public JButton getBdel2() {   return bdel2;  }
    public void setBdel2(JButton bdel2) {   this.bdel2 = bdel2;   }
    public JButton getBupd2() {     return bupd2;   }
    public void setBupd2(JButton bupd2) {   this.bupd2 = bupd2;   }
    public JButton getRefresh2() {    return refresh2;  }
    public void setRefresh2(JButton refresh2) {    this.refresh2 = refresh2;  }
    public JTextField getTidord() {    return tidord;  }
    public void setTidord(JTextField tidord) {   this.tidord = tidord;  }
    public JTextField getTidclo() {     return tidclo;  }
    public void setTidclo(JTextField tidclo) {    this.tidclo = tidclo;  }
    public JTextField getTidprodo() {    return tidprodo;   }
    public void setTidprodo(JTextField tidprodo) {    this.tidprodo = tidprodo;  }
    public JTextField getTcantito() {    return tcantito;  }
    public void setTcantito(JTextField tcantito) {    this.tcantito = tcantito;  }
    public JButton getBadd3() {    return badd3;  }
    public void setBadd3(JButton badd3) {   this.badd3 = badd3;   }
    public JButton getRefresh3() {   return refresh3;   }
    public void setRefresh3(JButton refresh3) { this.refresh3 = refresh3;  }
    public JPanel getClienti() {  return clienti; }
    public void setClienti(JPanel clienti) {  this.clienti = clienti;  }
    public JTable getTableCl() {  return tableCl; }
    public void setTableCl(JTable tableCl) { this.tableCl = tableCl;  }
    public JTable getTableProd() {    return tableProd;  }
    public void setTableProd(JTable tableProd) {   this.tableProd = tableProd;   }
    public JTable getTableOrd() {   return tableOrd;  }
    public void setTableOrd(JTable tableOrd) {  this.tableOrd = tableOrd;    }
}
