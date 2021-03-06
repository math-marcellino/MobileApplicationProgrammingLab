# Latihan, Tugas, dan Eksperimen
## 2. Lakukan pengujian terhadap app anda dengan skenario di bawah ini:
### a. Kosongkan Angka 1 dan Angka 2, lalu klik salah satu button
Muncul error dengan pesan "Week02_36291 keeps stopping", lalu aplikasi tertutup. (Muncul NumberFormatException: empty string pada logcat)
Penyebab error tersebut adalah karena kita tidak membuat Error Handling untuk menangani input yang masuk.
Untuk menangani error tersebut, kita harus menyertakan Error Handling sehingga ketika hal semacam itu terjadi, 
aplikasi akan menampilkan error message dan aplikasi tidak berhenti.

### b. Kosongkan Angka 2, lalu klik button Bagi.
Ketika dilakukan, error yang sama seperti pada nomor 1 terjadi. Tidak ada Error Handling yang
menangani input kosong pada aplikasi yang kita buat, sehingga yang perlu dilakukan adalah menambahkan kode Error Handling
agar aplikasi tidak berhenti ketika dimasukkan input kosong.

### c. Isi 0 (nol) pada Angka 2, lalu klik button Bagi.
Ketika hal tersebut dilakukan, tidak terjadi error, tetapi hasil yang di-output adalah "infinity".
Hal tersebut dapat terjadi karena dalam operasi matematika, jika suatu bilangan dibagi dengan 0 hasilnya adalah tak hingga.

## 3. Debugging
```java
btnKali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hitung('*'); //breakpoint
            }
        });

btnBagi.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        hitung('/'); //breakpoint
    }
});
```
Saya mengambil breakpoint pada saat btnKali dan btnBagi memanggil method 'hitung'
Ketika debugging app dijalankan, aplikasi berhenti sesuai dengan breakpoint yang telah ditentukan.
Pada kasus saya, aplikasi berhenti ketika button kali dan bagi ditekan. Setelah itu saya dapat memilih
opsi step over, step into, step out, dan resume untuk melanjutkan jalannya program.

- Pada saat step over dilakukan, debugger langsung menjalankan baris berikutnya lalu berhenti, 
sehingga debugger tidak menjalankan method 'hitung' dan tidak ada operasi yang dilakukan
- Pada saat step into dilakukan, debugger menjalankan fungsi method dan masuk ke dalamnya, tetapi
ia akan berhenti per baris sehingga kita dapat melakukan pengecekan terhadap setiap step pada method
tersebut
- Pada saat sudah masuk ke dalam method 'hitung', jika dilakukan step out, maka sisa baris dari method
tersebut akan dijalankan, lalu ia akan keluar dari method tersebut.
- Pada saat melakukan resume, maka program akan menjalankan kode setelah breakpoint sebelumnya.

Dengan debugging, kita dapat melakukan pengecekan terhadap aplikasi kita dengan lebih detail, karena
kita menelusuri potongan kode yang berpotensi memiliki masalah per baris.
