namespace java apachethrift   // namespace相当于java中的package
struct User { // 结构实体
	1: i32 id;
	2: string name;
	3: i32 age;
	4: string phone;
	5: string address;
}
service QueryService { // 接口
	User queryUser(1:i32 id);
	User addUser(1:User uer);
	list<User> getAll();
	void remove(1:i32 id);
}
//Thrift数据类型