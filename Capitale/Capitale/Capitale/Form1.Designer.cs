namespace Educational_Impact
{
    partial class Form1
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.gMaps = new System.Windows.Forms.WebBrowser();
            this.splitContainer = new System.Windows.Forms.SplitContainer();
            this.label6 = new System.Windows.Forms.Label();
            this.btn_generez = new System.Windows.Forms.Button();
            this.label5 = new System.Windows.Forms.Label();
            this.label4 = new System.Windows.Forms.Label();
            this.txt_capitala = new System.Windows.Forms.TextBox();
            this.txt_tara = new System.Windows.Forms.TextBox();
            this.lbl_win = new System.Windows.Forms.Label();
            this.lbl_loss = new System.Windows.Forms.Label();
            this.label3 = new System.Windows.Forms.Label();
            this.label2 = new System.Windows.Forms.Label();
            this.btn_confirm = new System.Windows.Forms.Button();
            this.label1 = new System.Windows.Forms.Label();
            ((System.ComponentModel.ISupportInitialize)(this.splitContainer)).BeginInit();
            this.splitContainer.Panel1.SuspendLayout();
            this.splitContainer.Panel2.SuspendLayout();
            this.splitContainer.SuspendLayout();
            this.SuspendLayout();
            // 
            // gMaps
            // 
            this.gMaps.Dock = System.Windows.Forms.DockStyle.Fill;
            this.gMaps.Location = new System.Drawing.Point(0, 0);
            this.gMaps.MinimumSize = new System.Drawing.Size(20, 20);
            this.gMaps.Name = "gMaps";
            this.gMaps.Size = new System.Drawing.Size(938, 462);
            this.gMaps.TabIndex = 0;
            this.gMaps.Url = new System.Uri("", System.UriKind.Relative);
            // 
            // splitContainer
            // 
            this.splitContainer.Dock = System.Windows.Forms.DockStyle.Fill;
            this.splitContainer.Location = new System.Drawing.Point(0, 0);
            this.splitContainer.Name = "splitContainer";
            this.splitContainer.Orientation = System.Windows.Forms.Orientation.Horizontal;
            // 
            // splitContainer.Panel1
            // 
            this.splitContainer.Panel1.BackgroundImage = global::Capitale.Properties.Resources.bkrnd_geogra;
            this.splitContainer.Panel1.Controls.Add(this.label6);
            this.splitContainer.Panel1.Controls.Add(this.btn_generez);
            this.splitContainer.Panel1.Controls.Add(this.label5);
            this.splitContainer.Panel1.Controls.Add(this.label4);
            this.splitContainer.Panel1.Controls.Add(this.txt_capitala);
            this.splitContainer.Panel1.Controls.Add(this.txt_tara);
            this.splitContainer.Panel1.Controls.Add(this.lbl_win);
            this.splitContainer.Panel1.Controls.Add(this.lbl_loss);
            this.splitContainer.Panel1.Controls.Add(this.label3);
            this.splitContainer.Panel1.Controls.Add(this.label2);
            this.splitContainer.Panel1.Controls.Add(this.btn_confirm);
            this.splitContainer.Panel1.Controls.Add(this.label1);
            // 
            // splitContainer.Panel2
            // 
            this.splitContainer.Panel2.Controls.Add(this.gMaps);
            this.splitContainer.Size = new System.Drawing.Size(938, 565);
            this.splitContainer.SplitterDistance = 99;
            this.splitContainer.TabIndex = 1;
            // 
            // label6
            // 
            this.label6.AutoSize = true;
            this.label6.BackColor = System.Drawing.Color.Transparent;
            this.label6.Font = new System.Drawing.Font("Comic Sans MS", 16F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label6.ForeColor = System.Drawing.Color.White;
            this.label6.Location = new System.Drawing.Point(974, 9);
            this.label6.Name = "label6";
            this.label6.Size = new System.Drawing.Size(365, 90);
            this.label6.TabIndex = 8;
            this.label6.Text = "Daca consideri ca stapanesti deja \r\ncapitalele , pune in aplicare ceea \r\nce ai in" +
    "vatat explorand harta lumii!";
            // 
            // btn_generez
            // 
            this.btn_generez.BackColor = System.Drawing.Color.LightSteelBlue;
            this.btn_generez.FlatStyle = System.Windows.Forms.FlatStyle.Popup;
            this.btn_generez.Font = new System.Drawing.Font("Comic Sans MS", 14F);
            this.btn_generez.ForeColor = System.Drawing.SystemColors.ControlText;
            this.btn_generez.Location = new System.Drawing.Point(413, 36);
            this.btn_generez.Name = "btn_generez";
            this.btn_generez.Size = new System.Drawing.Size(118, 39);
            this.btn_generez.TabIndex = 2;
            this.btn_generez.Text = "Genereaza";
            this.btn_generez.UseVisualStyleBackColor = false;
            this.btn_generez.Click += new System.EventHandler(this.btn_generez_Click);
            // 
            // label5
            // 
            this.label5.AutoSize = true;
            this.label5.BackColor = System.Drawing.Color.Transparent;
            this.label5.Font = new System.Drawing.Font("Comic Sans MS", 9F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label5.ForeColor = System.Drawing.Color.White;
            this.label5.Location = new System.Drawing.Point(555, 49);
            this.label5.Name = "label5";
            this.label5.Size = new System.Drawing.Size(53, 17);
            this.label5.TabIndex = 7;
            this.label5.Text = "Capitala";
            // 
            // label4
            // 
            this.label4.AutoSize = true;
            this.label4.BackColor = System.Drawing.Color.Transparent;
            this.label4.Font = new System.Drawing.Font("Comic Sans MS", 9F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label4.ForeColor = System.Drawing.Color.White;
            this.label4.Location = new System.Drawing.Point(555, 3);
            this.label4.Name = "label4";
            this.label4.Size = new System.Drawing.Size(34, 17);
            this.label4.TabIndex = 6;
            this.label4.Text = "Tara";
            // 
            // txt_capitala
            // 
            this.txt_capitala.CharacterCasing = System.Windows.Forms.CharacterCasing.Upper;
            this.txt_capitala.Enabled = false;
            this.txt_capitala.Font = new System.Drawing.Font("Comic Sans MS", 10F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.txt_capitala.Location = new System.Drawing.Point(558, 67);
            this.txt_capitala.Name = "txt_capitala";
            this.txt_capitala.Size = new System.Drawing.Size(174, 26);
            this.txt_capitala.TabIndex = 5;
            // 
            // txt_tara
            // 
            this.txt_tara.CharacterCasing = System.Windows.Forms.CharacterCasing.Upper;
            this.txt_tara.Enabled = false;
            this.txt_tara.Font = new System.Drawing.Font("Comic Sans MS", 10F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.txt_tara.Location = new System.Drawing.Point(558, 23);
            this.txt_tara.Name = "txt_tara";
            this.txt_tara.Size = new System.Drawing.Size(174, 26);
            this.txt_tara.TabIndex = 1;
            // 
            // lbl_win
            // 
            this.lbl_win.AutoSize = true;
            this.lbl_win.BackColor = System.Drawing.Color.Transparent;
            this.lbl_win.Font = new System.Drawing.Font("Comic Sans MS", 9F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.lbl_win.ForeColor = System.Drawing.Color.White;
            this.lbl_win.Location = new System.Drawing.Point(354, 37);
            this.lbl_win.Name = "lbl_win";
            this.lbl_win.Size = new System.Drawing.Size(15, 17);
            this.lbl_win.TabIndex = 4;
            this.lbl_win.Text = "0";
            // 
            // lbl_loss
            // 
            this.lbl_loss.AutoSize = true;
            this.lbl_loss.BackColor = System.Drawing.Color.Transparent;
            this.lbl_loss.Font = new System.Drawing.Font("Comic Sans MS", 9F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.lbl_loss.ForeColor = System.Drawing.Color.White;
            this.lbl_loss.Location = new System.Drawing.Point(352, 70);
            this.lbl_loss.Name = "lbl_loss";
            this.lbl_loss.Size = new System.Drawing.Size(15, 17);
            this.lbl_loss.TabIndex = 3;
            this.lbl_loss.Text = "0";
            // 
            // label3
            // 
            this.label3.AutoSize = true;
            this.label3.BackColor = System.Drawing.Color.Transparent;
            this.label3.Font = new System.Drawing.Font("Comic Sans MS", 9F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label3.ForeColor = System.Drawing.Color.White;
            this.label3.Location = new System.Drawing.Point(234, 70);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(119, 17);
            this.label3.TabIndex = 3;
            this.label3.Text = "Raspunsuri gresite :";
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.BackColor = System.Drawing.Color.Transparent;
            this.label2.Font = new System.Drawing.Font("Comic Sans MS", 9F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label2.ForeColor = System.Drawing.Color.White;
            this.label2.Location = new System.Drawing.Point(234, 37);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(121, 17);
            this.label2.TabIndex = 2;
            this.label2.Text = "Raspunsuri corecte :";
            // 
            // btn_confirm
            // 
            this.btn_confirm.BackColor = System.Drawing.Color.LightSteelBlue;
            this.btn_confirm.FlatStyle = System.Windows.Forms.FlatStyle.Popup;
            this.btn_confirm.Font = new System.Drawing.Font("Comic Sans MS", 12F);
            this.btn_confirm.ForeColor = System.Drawing.SystemColors.ControlText;
            this.btn_confirm.Location = new System.Drawing.Point(761, 35);
            this.btn_confirm.Name = "btn_confirm";
            this.btn_confirm.Size = new System.Drawing.Size(150, 39);
            this.btn_confirm.TabIndex = 1;
            this.btn_confirm.Text = "Confirma alegerea";
            this.btn_confirm.UseVisualStyleBackColor = false;
            this.btn_confirm.Click += new System.EventHandler(this.btn_confirm_Click);
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.BackColor = System.Drawing.Color.Transparent;
            this.label1.Font = new System.Drawing.Font("Comic Sans MS", 16F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label1.ForeColor = System.Drawing.Color.White;
            this.label1.Location = new System.Drawing.Point(126, 27);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(102, 60);
            this.label1.TabIndex = 0;
            this.label1.Text = "Ghiceste\r\ncapitala!";
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(938, 565);
            this.Controls.Add(this.splitContainer);
            this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.FixedSingle;
            this.Name = "Form1";
            this.Text = "Form1";
            this.splitContainer.Panel1.ResumeLayout(false);
            this.splitContainer.Panel1.PerformLayout();
            this.splitContainer.Panel2.ResumeLayout(false);
            ((System.ComponentModel.ISupportInitialize)(this.splitContainer)).EndInit();
            this.splitContainer.ResumeLayout(false);
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.WebBrowser gMaps;
        private System.Windows.Forms.SplitContainer splitContainer;
        private System.Windows.Forms.Label label6;
        private System.Windows.Forms.Button btn_generez;
        private System.Windows.Forms.Label label5;
        private System.Windows.Forms.Label label4;
        private System.Windows.Forms.TextBox txt_capitala;
        private System.Windows.Forms.TextBox txt_tara;
        private System.Windows.Forms.Label lbl_win;
        private System.Windows.Forms.Label lbl_loss;
        private System.Windows.Forms.Label label3;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.Button btn_confirm;
        private System.Windows.Forms.Label label1;
    }
}

