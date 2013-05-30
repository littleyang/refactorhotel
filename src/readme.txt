说明文档:

A)、源文件的包的结构
	共包括了七个包，分别如下:
	1. per.tw.customer.common里面是customer类的一些方法的公共接口
	2. per.tw.customer.compator里面是hotel list比较器类
	3. per.tw.customer.data.adapter里面是customer 字符串处理的适配器类
	4. per.tw.customer.data.common里面是关于customer字符串处理的方法类的公共接口
	5. per.tw.customer.data.imp里面是customer数据处理的具体实现类
	6. per.tw.customer.databean里面是customer关于hotel list的比较辅助类
	7. per.tw.hotel.common里面为hotel类的公共处理方法接口
	8. per.tw.model.customer里面为customer类
	9. per.tw.model.customer.base里面为customer基础类
	10. per.tw.model.hotel里面包含了hotel类
	12. per.tw.model.hotel.base里面包含了hotel基础类
	13. per.tw.test.lib 为使用的Junit包
	14. per.tw.tmethod为方法测试
	15. per.tw.test.utest为单元测试
	

B)、使用以及运行测试说明:
   	1. 每个单元测试都是单独运行的，如果有必要请将per.tw.test.lib下面的jar文件添加到build path中

   	   