Design Pattern
- Cung cấp cho chúng ta các mẫu thiết kế, các giải pháp cho các vấn đề chung thường gặp trong lập trình, đảm bảo sẽ cung cấp cho chúng ta các giải pháp tối ưu trong việc giải quyết các vấn đề trong lập trình.
- Phân loại design pattern:
Nhóm khởi tạo (Creational): giúp chúng ta trong việc khởi tạo các đối tượng, cung cấp các thủ thuật để khởi tạo đối tượng mà không cần đến từ khóa “new”. VD: Abstract Factory, Factory Method, Singleton, Builder, Prototype 
Nhóm cấu trúc (Structural): thường dùng để giải quyết mối quan hệ giữa các thực thể (entity	), giúp thao tác với các đối tượng dễ dàng hơn. VD: Adapter, Bridge, Composite, Decorator, Facade, Proxy và Flyweight...
Nhóm hành vi (Behavioral): dùng trong việc thể hiện các hành vi của đối tượng, tương tác (communicate) giữa các đối tượng dễ dàng hơn. VD: Interpreter, Template Method, Chain of Responsibility, Command, Iterator, Mediator, Memento, Observer, State, Strategy và Visitor...

Repository Pattern


![no-repo-pattern](https://user-images.githubusercontent.com/74781135/164414089-1ccdae24-e2f3-412b-bf43-11bd16ba15bd.png)




Controller được gắn chặt với Model - dùng để thực hiện các thao tác với Cơ sở dữ liệu (database)
Điều này gây ra 2 vấn đề nghiêm trọng như sau nếu ta không để ý:
1. Chúng ta không thể viết Test cho Controller.


2.Controller vô hình chung đã bị gắn chặt với Object Relational Mapping  Layer, nếu trong tương lai chúng ta muốn thay đổi cấu trúc bảng hay thực hiện giải pháp nào đó tái cấu trúc, chúng ta sẽ gặp khó khăn trong việc phải tìm lại toàn bộ các controller và sửa.



Trong nhiều ứng dụng, business logic truy cập dữ liệu từ nơi lưu trữ dữ liệu như 
database, SharePoint list hoặc Web services, … Việc truy cập trực tiếp vào dữ liệu có thể dẫn đến:
Duplicated code
Khả năng xảy ra lỗi lập trình cao hơn
Không có khả năng dễ dàng kiểm tra logic nghiệp vụ tách biệt khỏi các yếu tố phụ thuộc bên ngoài
Mục tiêu khi sử dụng Repository Pattern:
Tối đa hóa lượng mã có thể được kiểm tra bằng tự động hóa và cô lập lớp dữ liệu để hỗ trợ kiểm tra đơn vị.
Truy cập nguồn dữ liệu từ nhiều vị trí và muốn áp dụng các quy tắc và logic truy cập được quản lý tập trung, nhất quán.
Triển khai và tập trung chiến lược bộ nhớ đệm cho nguồn dữ liệu.
Cải thiện khả năng bảo trì và khả năng đọc của mã bằng cách tách logic nghiệp vụ khỏi dữ liệu hoặc logic truy cập dịch vụ.
Sử dụng các thực thể kinh doanh được đánh máy mạnh để bạn có thể xác định các vấn đề tại thời điểm biên dịch thay vì tại thời điểm chạy.
Liên kết một hành vi với dữ liệu liên quan. Ví dụ: bạn muốn tính toán các trường hoặc thực thi các mối quan hệ phức tạp hoặc các quy tắc kinh doanh giữa các phần tử dữ liệu trong một thực thể.
Áp dụng mô hình miền để đơn giản hóa logic nghiệp vụ phức tạp.


Solution: 





![have-repo-pattern](https://user-images.githubusercontent.com/74781135/164414110-c5d0a7cf-5353-45b8-8101-fec60ce24de4.png)










Repository là một trong những mẫu thiết kế quan trọng và dễ dàng nhất mà bạn có thể sử dụng và xem, đặc biệt khi bạn cần một lớp để xử lý quyền truy cập dữ liệu cho dù dữ liệu này nằm trong cơ sở dữ liệu hay bộ lưu trữ khác.
Sử dụng ở đâu:
Ngăn truy vấn trùng lặp
Trong một hệ thống mà có nhiều truy vấn
Nó được sử dụng để tìm kiếm hoặc xóa phần tử bằng cách sử dụng đặc tả của thực thể mà kho lưu trữ đã tạo.
 
Sử dụng 1 repository để tách logic truy xuất dữ liệu và ánh xạ nó tới entity model từ business logic hoạt động trên model đó. 
 
Repository là trung gian giữa data source layer (Data Access) và business layer (Business Logic) của ứng dụng, giúp việc truy cập dữ liệu chặt chẽ và bảo mật hơn. Nó truy vấn dữ liệu từ data source, maps dữ liệu từ data source vào business entity. Repository ngăn cách business logic khỏi các tương tác với data source hoặc web service bên dưới. 






![repo-pattern](https://user-images.githubusercontent.com/74781135/164414162-135ee282-03b8-4f8d-9e5f-f32034e64269.png)







Có 2 cách repo có thể truy vấn business entities. Nó có thể gửi một đối tượng truy vấn đến logic nghiệp vụ của khách hàng hoặc nó có thể sử dụng các phương pháp chỉ định các tiêu chí nghiệp vụ. Trong trường hợp thứ hai, kho lưu trữ hình thành truy vấn thay mặt khách hàng. Kho lưu trữ trả về một tập hợp các thực thể phù hợp đáp ứng truy vấn. Sơ đồ sau đây cho thấy các tương tác của kho lưu trữ với máy khách và nguồn dữ liệu.










![repo](https://user-images.githubusercontent.com/74781135/164414179-f091b5bb-aae0-4e63-aedc-989930fa95bc.png)









Lợi ích và hạn chế:
1. Lợi ích:
Tập trung vào logic về xử lý dữ liệu hoặc business logic
Cho phép dễ dàng kiểm tra ứng dụng bằng unit tests
Cải thiện tính linh hoạt của kiến trúc
2. Hạn chế:
Về hiệu suất: Thư viện kho lưu trữ càng trừu tượng, chúng ta sẽ cần thiết kế và triển khai nhiều cấp độ trừu tượng hơn, bao gồm nhiều trường hợp hơn. Tuy nhiên, một kho lưu trữ chuyên biệt sẽ hoạt động tốt hơn, biết được toàn bộ khả năng của kho lưu trữ cơ bản của nó.
Một bất lợi khác là chi phí phát triển và bảo trì. Những nhược điểm này vượt trội hơn bất kỳ lợi thế nào của việc có một cấu trúc hoàn toàn chung chung…

