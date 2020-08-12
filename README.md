# Binder
## AIDL基础
参考 [android跨进程通信（IPC）：使用AIDL](https://blog.csdn.net/singwhatiwanna/article/details/17041691)

### server/client
> 通过AIDL自动实现Binder实现跨进程通讯
- server 远程服务端
- client 本地客户端（与server不是同一个app）
  - 自定数据类型的传输时候，需要将服务端的数据模型原样拷贝（包含包名）
  - 通讯的时候，可以选择直接拷贝服务端的aidl文件，也可以拷贝aidl文件生成的java文件

### app
手动实现Binder跨进城通讯，其中远程和本地都在一个app内
