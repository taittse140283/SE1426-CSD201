## 🔥🔥🔥CSD201 - LAB 1 🔥🔥🔥

### Hiện thực 2 bài toán bằng ⚡Java⚡:

**Bài toán 1**. Một mobile game có **hơn 5 triệu** người chơi, thông tin cần lưu trữ người chơi bao gồm email và point (điểm số), hãy **tự xây dựng** một cấu trúc dữ liệu (thông qua các kiến thức đã học) giúp thực hiện các chức năng quản lý thông tin người chơi **một cách hiệu quả**. Các chức năng cần để quản lý thông tin người chơi bao gồm: thêm (add), xóa (delete), sửa (update) và tìm kiếm (get). Yêu cầu độ phức tạp của giải thuật khi thực hiện các chức năng phải đạt **yêu cầu tối thiểu** là **O(N)**, riêng với chức năng tìm kiếm và xóa ứng với **người chơi có điểm số cao nhất** có độ phức tạp là **O(1)**.
**Bài toán 2**. Xây dựng một cấu trúc dữ liệu **stack dựa trên array** với các thao tác **pop** và **push** có độ phức tạp là **O(1)**. Sử dụng cấu trúc stack vừa được xây dựng truy xuất đến một website bất kỳ (ví dụ: vnexpress.net) và **thống kê số html TAG** được sử dụng trong website đó. Dữ liệu thống kê sẽ được ghi vào file CSV với thứ tự các tag tương ứng tần suất xuất hiện của nó từ cao đến thấp.

### Các kiến thức cơ bản để xây dựng được chương trình 

1. Chương trình được viết trên mô hình OOP.

2. Sử dụng công nghệ GIT để quản mã nguồn.

3. Sử dụng các cấu trúc dữ liệu như DoubleLinkedList, ArrayStack, Priority Queue,...
4. Hiểu cơ bản về độ phức tạp của giải thuật.
5. Biết cách nén các file thành tệp jar.
6. Biết sử dụng CLI trong java.

### Hướng dẫn sử dụng

1. Ứng dụng cung cấp giao diện dòng lệnh cơ bản CLI, hổ trợ các cú pháp sau:
   ```
   # Hướng dẫn sử dụng
   ./lab1 -h
   Help: 
   java -jar LAB1.jar 1 -r <<user_CSV_file>> -s <<new_user_CSV_file>>: Problem 1, read the user csv file and save the data strucutre into csv file 
   java -jar LAB1.jar 1 -r <<user_CSV_file>> -s <<new_user_CSV_file>> -a <<email>> <<point>>: Problem 1, add a new user into the data strucutre and save to new csv file
   java -jar LAB1.jar 1 -r <<user_CSV_file>> -s <<new_user_CSV_file>> -d <<email>>: Problem 1, delete a user in the data strucutre and save to new csv file
   java -jar LAB1.jar 1 -r <<user_CSV_file>> -s <<new_user_CSV_file>> -u <<email>> <<new_point>>: Problem 1, update new point for user in the data strucutre and save to new csv file
   java -jar LAB1.jar 1 -r <<user_CSV_file>> -s <<new_user_CSV_file>> -dt: Problem 1, delete the top user from the data strucutre and save to new csv file
   java -jar LAB1.jar 1 -r <<user_CSV_file>> -g <<email>>: Problem 1, get the point of user from the data strucutre
   java -jar LAB1.jar 1 -r <<user_CSV_file>> -t: Problem 1, get the point of the top user from the data strucutre
   java -jar LAB1.jar 2 <<URL-of-website>> <<output-CSV-file>>: Problem 2, read html info from a URL, save all tag information into the CSV output file
   ```
2. Chuẩn đầu vào và đầu ra của ứng dụng
   
   ```
   # USER CSV FILE
   Email, Point
   abcv203@gmail.com, 250
   febgulinda8@outlook.com, 30
   thinkerabc@yahoo.com, 356
   ...

   # OUTPUT CSV FILE
   Tag, Frequence
   div, 523
   img, 34
   li, 12
   ...
   ```

### Xây dựng chương trình 
####Bài toán 1 :
Phân tích yêu cầu: 
- Bài toán yêu cầu lưu trữ một lượng lớn thông tin người chơi không biết trước số lượng. Do đó chúng ta có thể sử dụng LinkedList để lưu trữ thông tin người chơi với số lượng lớn.
- Chức năng tìm kiếm và xóa người chơi với điểm số cao nhất có độ phức tạp của giải thuật là O(1) ==> Phải sắp xếp trước khi tìm kiếm hoặc xóa người chơi cao nhất ==> Sử dụng Priority Queu để thực hiện bài toán này.

Ý tưởng xây dựng chương trình:
- Bài toán được xây dựng trên DoubleLinkedList , được sắp xếp theo thứ tự điểm của người chơi từ thấp đến cao , nếu điếm số bằng nhau thì người vào sau sẽ xếp sau người vào trước.
. Nhưng in ra file với thứ tự từ cao đến thấp. 
- Quy ước vị trí trong List: Vị trí 0 là vị trí con trỏ header.next chỉ vào và vị trí cuối cùng là con trỏ trailer,prev

Giải thích và chức năng của từng hàm trong bài toán :
- Có 2 hàm đặc biệt là hàm **getNode** và **getElementNode**. Hàm **getNode** sử dụng để tìm kiếm Node theo vị trí chuyền vào. Sử dụng 1 biến temp (temp = header.next)để lưu vị trí 0 trong list. Sử dụng vòng for và temp.next để nhảy đến vị trí được truyền vào. Và trả lại kết quả là Node ở vị trí đó.
Còn hàm  **getElementNode** thì có mục đích lấy ra info của người chơi ở node đó bằng cách tái sử dụng lại hàm **getNode**. Mục đích của 2 hàm này là để dễ dàng tìm kiếm thông tin hoặc Node để so sánh, xóa, sửa,...  
- Hàm **insert** trong class SortList có chức năng tìm kiếm vị trí chèn vào phù hợp: tham số truyền vào là Info của người chơi . Nếu mảng chưa chứa Node nào thì tạo Node để lưu info người chơi. Nếu mảng đã có rồi thì chúng ta sẽ có 3 trường hợp như sau. **TH1:** điểm số người chơi mới truyền vào cao nhất thì sẽ tạo một Node mới vào cuối cùng của list và chứa info đó. **TH2:** điểm số của người chơi truyền vào nhỏ hơn hoặc bằng người chơi có điểm số thấp nhất trong 
list thì thêm một Node ở đầu list và add info người chơi vào. **TH3:** điểm số của người chơi truyền vào nhỏ hơn hoặc bằng người chơi cao nhất và lớn hơn người chơi có điểm số thấp nhất. Vì đây là list được sắp xếp theo điểm người chơi tăng dần nên ta tìm kiếm vị trí từ đầu list đến cuối list nếu điểm của người chơi lớn hơn hoặc bằng vị trí node đó thì tạo Node mới đứng trước Node mới tìm được add info người chơi vào.

####Bài toán 2 :
Ý tưởng xây dựng chương trình:
- Sử dụng Hashmap để lưu lại Tên của các Tag và số lần xuất hiện của các Tag
- Đối với những tag đơn trong HTML thì không cần phải sử dụng pop và put. Những tag comment trong html thì cũng sẽ bị bỏ qua.
Lưu lại hết những tag có đóng và mở trong HTML 

Giải thích và chức năng của từng hàm trong bài toán :
- hàm getStringfromWeb dùng để lấy dữ liệu từ Web chuyển sang String để dễ dàng đọc 
- hàm countTag dùng để đếm các Tag đã sử dụng trong HTML và tham số truyền vào là String từ hàm getStringfromWeb trả về là HashMap lưu lại thông tin 
- hàm crawWeb dùng để xử lí và lưu lại thành file