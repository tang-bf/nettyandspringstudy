namespace java thrift.generated
typedef i16 short
typedef i32 int
typedef i64 long
typedef bool boolean
typedef string String
struct Person {
1:optional String username,
2:optional int age,
3:optional boolean married

}
exception dataException{
1:optional String message,
2:optional String callBack,
3:optional String dayte
}
service PersonServese{
Person getPersonByName(1:required String userName ) throws (1:dataException dataException),
void save(1:Person person ) throws (1:dataException dataException)
}