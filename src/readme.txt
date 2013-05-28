说明文档:

A)、源文件的包的结构
	共包括了七个包，分别如下:
	1. per.tw.compator里面是hotel list比较器类和单元测试文件
	2. per.tw.customer里面是客户类和单元测试文件
	3. per.tw.databean里面是hotel和customer操作的中间辅助类，用于比较和信息保存
	4. per.tw.hotelmodel里面包含了hotel类和hotel的单元才测试文件
	5. per.tw.source.back.not.used里面是不再使用的了的备份文件和一些相关类
	6. per.tw.test.lib包含了两个Junit测试包，可以使用eclipse自带的测试包
	7. per.tw.hotel.test下面是简单的方法集合测试，可直接运行文件。如有必要请修改(data.txt)为自己的路径即可。
	8. per.tw.testu里面包含了两个测试文件:一个是所有单元测的整体测试和一个Main测试类。
	9. class_diagram.png是所有类的UML图
	10. data.txt是测试所需要读取的数据文件
	11. readme.txt是说明文件

B)、使用以及运行测试说明:
   	1. 每个单元测试都是单独运行的，如果有必要请将per.tw.test.lib下面的jar文件添加到build path中
   	2. 对于简单的方法测试类(TestJustTheMethod.java)因为里面需要读取文件，如果有必要请将文件读取的路径修改为自己的路径
   	3. 单元测试套件测试类(AllTestsAboutTheHotelAndCustomer.java)也可能需要修改文件读取路径
   	4. 2，3都是在per.tw.testu包下面
   	5. 3里面需要修改读取路径的类和方法为(最后一个方法)：
   	   CustomerTest.java里面的testSearchHotelAndFindAndReturnCheapestAndBestOneByReadTheDataFile()方法。
   	6. 在运行测试时，如果有必要请添加Junit Test包。
   	   