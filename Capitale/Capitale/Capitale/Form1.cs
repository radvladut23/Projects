using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Educational_Impact
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        public int turn = 0;

        public string[] lista = { "0", "FRANTA", "PARIS", "CANADA", "OTTAWA", "SUA", "WASHINGTON", "MEXIC", "CIUDAD DE MEXICO", "COSTA RICA", "SAN JOSE", "GUATEMALA", "GUATEMALA", "PANAMA", "PANAMA", "SALVADOR", "SAN SALVADOR", "CUBA", "HAVANA", "JAMAICA", "KINGSTON", "ARGENTINA", "BUENOS AIRES", "CHILE", "SANTIAGO", "BRAZILIA", "BRASILIA", "PERU", "LIMA", "URUGUAY", "MONTEVIDEO", "VENEZUELA", "CARACAS", "RUSIA", "MOSCOVA", "CHINA", "BEIJING", "COREEA DE NORD", "PHENANG", "COREEA DE SUD", "SEUL", "HONG-KONG", "HONG-KONG", "JAPONIA", "TOKIO", "MACAO", "MACAO", "TAIWAN", "TAIPEI", "AFGANISTAN", "KABUL", "KAZAHSTAN", "ASTANA", "FILIPPINE", "MANILLA", "MALAYSIA", "KUALA LUMPUR", "SINGAPORE", "SINGAPORE", "THAILANDA", "BANGKOK", "VIETNAM", "HANOI", "BANGLADESH", "DACCA", "INDIA", "NEW DELHI", "NEPAL", "KATMANDU", "PAKISTAN", "ISLAMABAD", "ARABIA SAUDITA", "AR RIYADH", "ARMENIA", "EREVAN", "IRAN", "TEHERAN", "IRAK", "BAGDAD", "ISRAEL", "IERUSALIM", "TURCIA", "ANKARA", "SIRIA", "DAMASC", "ALBANIA", "TIRANA", "AUSTRIA", "VIENA", "BELARUS", "MINSK", "CROATIA", "ZAGREB", "BULGARIA", "SOFIA", "FINLANDA", "HELSINKI", "GERMANIA", "BERLIN", "UNGARIA", "BUDAPESTA", "IRLANDA", "DUBLIN", "ITALIA", "ROMA", "GRECIA", "ATENA", "MOLDOVA", "CHISINAU", "ROMANIA", "BUCURESTI", "SPANIA", "MADID", "PORTUGALIA", "LISABONA", "SERBIA", "BELGRAD", "SUEDIA", "STOCKHOLM", "UCRAINA", "KIEV", "MAREA BRITANIE", "LONDRA", "VATICAN", "VATICAN" };

        public int nr = 0;

        //functie navigare;
        public void navigate()
        {
            if (turn == 1)
                txt_capitala.Text = lista[nr + 1].ToString();
            else if (turn == 2)
                txt_tara.Text = lista[nr - 1].ToString();

            string tara = txt_tara.Text;
            string capitala = txt_capitala.Text;
            //pregatire bing maps si creare queryadress;
            try
            {
                StringBuilder queryadress = new StringBuilder();
                queryadress.Append("http://www.bing.com/maps/?v=2&where1=");
                queryadress.Append(tara + "," + "+");
                queryadress.Append(capitala + "," + "+");
                queryadress.Append("&sty=h");
                gMaps.Navigate(queryadress.ToString());
            }
            catch (Exception ex)
            {
                MessageBox.Show(ex.Message.ToString(), "Eroare :");
            }
        }
        private void btn_confirm_Click(object sender, EventArgs e)
        {
            //verifica daca raspunsul este corect in ambele cazuri;
            if (turn == 1)
            {
                if (txt_capitala.Text == lista[nr + 1].ToString())
                {
                    MessageBox.Show("Raspuns corect. Te descurci foarte bine!");
                    lbl_win.Text = ((Convert.ToInt32(lbl_win.Text) + 1).ToString());
                }
                else
                {
                    MessageBox.Show("Raspuns gresit. Mai exerseaza!");
                    lbl_loss.Text = ((Convert.ToInt32(lbl_loss.Text) + 1).ToString());
                }
            }
            else if (turn == 2)
            {
                if (txt_tara.Text == lista[nr - 1].ToString())
                {
                    MessageBox.Show("Raspuns corect. Te descurci foarte bine!");
                    lbl_win.Text = ((Convert.ToInt32(lbl_win.Text) + 1).ToString());
                }
                else
                {
                    MessageBox.Show("Raspuns gresit. Mai exerseaza!");
                    lbl_loss.Text = ((Convert.ToInt32(lbl_loss.Text) + 1).ToString());
                }
            }
            //afiseaza locatia corecta pe harta;
            navigate();
            turn = 0;
            nr = 0;
            txt_capitala.Clear();
            txt_tara.Clear();
            txt_capitala.Enabled = false;
            txt_tara.Enabled = false;
        }

        private void btn_generez_Click(object sender, EventArgs e)
        {
            //genereaza tipul intrebarii si perechea capitala/tara;
            txt_tara.Clear();
            txt_capitala.Clear();
            Random rand = new Random();
            nr = rand.Next(1, 125);
            if (nr % 2 == 0)
                turn = 2;
            else if (nr % 2 == 1)
                turn = 1;
            txt_tara.Enabled = true;
            txt_capitala.Enabled = true;
            if (turn == 1)
            {
                txt_tara.Text = lista[nr].ToString();
                txt_tara.Enabled = false;
            }
            else if (turn == 2)
            {
                txt_capitala.Text = lista[nr].ToString();
                txt_capitala.Enabled = false;
            }
        }

        private void Geografie_Load(object sender, EventArgs e)
        {
            //navigare initiala la harta globului;
            gMaps.ScriptErrorsSuppressed = true;
            gMaps.Navigate("https://www.bing.com/maps?osid=44fa4330-9044-45ce-b11a-e5aaa264827f&cp=47.823527~56.909077&lvl=3&style=h&v=2&sV=2&form=S00027");
        }
    }
}
