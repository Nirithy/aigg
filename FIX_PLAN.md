# GG修改器源码修复计划

## 项目概述

本项目是一个反编译后的GG修改器(GameGuardian)源码，需要修复并升级luaj库到3.0.2版本。

## 当前状态分析

### 1. 项目结构

```
AiGG/
├── android/          # Android平台相关代码
│   ├── a/            # 混淆包
│   ├── b/            # 混淆包
│   ├── c/            # 混淆包
│   ├── ext/          # 扩展功能(核心代码)
│   ├── fix/          # UI修复类
│   └── lang/         # 语言相关
├── catch_/           # 资源文件
├── lasm/             # Lua汇编器
├── luaj/             # 当前luaj库(混淆版本)
└── luaj302/          # 下载的luaj 3.0.2源码
```

### 2. 当前luaj版本问题

当前项目使用的luaj库是**混淆后的反编译代码**，存在以下问题：

| 混淆类名 | 推测原始类名 | 说明 |
|---------|------------|------|
| `luaj.al` | `Prototype` | Lua函数原型 |
| `luaj.ap` | `Varargs` | 可变参数基类 |
| `luaj.o` | `LuaError` | Lua错误类 |
| `luaj.f` | `LoadState` | 加载状态 |
| `luaj.e` | `Undumper` | 反序列化接口 |
| `luaj.b` | `Compiler` | 编译器接口 |
| `luaj.c` | `Loader` | 加载器接口 |
| `luaj.d` | `BufferedInputStream` | 缓冲输入流 |
| `luaj.aj` | `Varargs` | 可变参数 |
| `luaj.z` | `TailcallVarargs` | 尾调用变量参数 |
| `luaj.n` | `LuaError` | Lua错误子类 |
| `luaj.l` | `LocVars` | 局部变量信息 |
| `luaj.ao` | `Upvaldesc` | Upvalue描述 |

### 3. 包名差异

| 当前项目 | luaj 3.0.2 |
|---------|-----------|
| `luaj.*` | `org.luaj.vm2.*` |
| `luaj.lib.*` | `org.luaj.vm2.lib.*` |
| `luaj.a.*` | `org.luaj.vm2.compiler.*` |

### 4. API差异分析

#### Globals类差异

| 当前版本 | luaj 3.0.2 |
|---------|-----------|
| `Globals.c()` | `checkglobals()` |
| `Globals.a(InputStream, String, String, LuaValue)` | `load(InputStream, String, String, LuaValue)` |
| `Globals.a(InputStream, String)` | `compilePrototype(InputStream, String)` |
| 字段 `a, b, c, d, e, f, g, h, i, j, k, l, m, n` | `STDIN, STDOUT, STDERR, finder, running, baselib, package_, debuglib, loader, compiler, undumper` |

#### LuaValue类差异

| 当前版本 | luaj 3.0.2 |
|---------|-----------|
| `LuaValue.f_()` | `typename()` |
| `LuaValue.c(int)` | `arg(int)` |
| `LuaValue.j_()` | `narg()` |
| 静态字段 `A, B, C...` | `NIL, TRUE, FALSE, NONE...` |

---

## 修复计划

### 阶段一：准备工作

#### 任务1.1：建立类名映射表
- [x] 完整分析所有混淆类名与原始类名的对应关系
- [x] 记录所有方法名映射关系
- [x] 记录所有字段名映射关系

#### 任务1.2：分析依赖关系
- [x] 分析GG修改器核心代码对luaj的依赖
- [x] 识别自定义扩展类(如GgLib)
- [x] 识别需要保留的自定义功能

---

### 任务1.2 分析结果
#### 1. GG修改器核心代码对luaj的依赖
- 核心依赖集中在 `android/ext/` 目录下（如 `Script.java` 及其大量内部类如 `Script$*`），共有数百处使用了 `import luaj.*`。
- 依赖的核心类包括但不限于：`luaj.Globals`, `luaj.LuaValue`, `luaj.LuaTable`, `luaj.LuaString`, `luaj.LuaNumber`, `luaj.ap` (Varargs), `luaj.o` (LuaError), 和 `luaj.z` (TailcallVarargs)。

#### 2. 自定义扩展类
- `luaj.lib.GgLib` 和内部类 `luaj.lib.GgLib$saveVariable`：实现了GG修改器特有的 `gg.saveVariable` API 功能。
- `luaj.lib.i`：一个自定义的 `FileOutputStream` 实现，用于受限的底层文件写入控制。

#### 3. 需要保留的自定义功能
- **文件 I/O 限制**：在 `Globals.java` 中的 `a(long)` 和 `a(String)` 方法控制了文件写入量和同时打开文件的数量限制。
- **Lua 汇编器 (lasm) 支持**：在 `Globals.a(InputStream, String, String)` 中识别并组装 `lasm` 生成的二进制格式或文本代码。
- **特有的系统库替换**：例如在 `Script.java` 中实例化的 `Script.IoLibSafe` 和 `Script.OsLibSafe`。

---

### 阶段二：luaj库替换

#### 任务2.1：删除旧的luaj库
- [x] 备份当前`luaj/`目录
- [x] 保留自定义类(如`GgLib.java`)

#### 任务2.2：集成luaj 3.0.2
- [x] 将`luaj302/src/core/org/luaj/`复制到项目
- [x] 调整包结构适配Android环境
- [x] 添加必要的JSE兼容类

#### 任务2.3：处理缺失类
luaj 3.0.2中可能缺少的类(需要从JSE版本获取或自行实现)：
- [x] `Buffer.java` - 缓冲区类
- [x] `LuaInteger.java` - 整数类
- [x] `LuaUserdata.java` - 用户数据类
- [x] `Metatable.java` - 元表接口
- [x] `OrphanedThread.java` - 孤立线程

---

### 阶段三：代码适配

#### 任务3.1：更新导入语句
需要批量修改的导入：
```java
// 旧导入
import luaj.Globals;
import luaj.LuaValue;
import luaj.lib.BaseLib;

// 新导入
import org.luaj.vm2.Globals;
import org.luaj.vm2.LuaValue;
import org.luaj.vm2.lib.BaseLib;
```

#### 任务3.2：更新方法调用
需要批量替换的方法调用：
```java
// 旧方法 -> 新方法
Globals.c() -> globals.checkglobals()
LuaValue.f_() -> value.typename()
LuaValue.c(int) -> value.arg(int)
LuaValue.j_() -> value.narg()
```

#### 任务3.3：更新字段访问
需要批量替换的字段访问：
```java
// 旧字段 -> 新字段
LuaValue.u -> LuaValue.NIL
LuaValue.v -> LuaValue.TRUE
LuaValue.w -> LuaValue.FALSE
LuaValue.x -> LuaValue.NONE
```

---

### 阶段四：核心文件修复

#### 任务4.1：修复Script.java
文件位置: `android/ext/Script.java`

需要修改的内容：
- [ ] 更新所有luaj导入语句
- [ ] 修复Globals初始化代码
- [ ] 修复LuaValue方法调用
- [ ] 修复LuaString静态方法调用

#### 任务4.2：修复Globals.java
文件位置: `luaj/Globals.java`

需要修改的内容：
- [ ] 合并GG修改器特有的功能到新版本
- [ ] 保留`a(long)`方法(文件写入限制)
- [ ] 保留`a(String)`方法(文件打开限制)
- [ ] 保留lasm汇编器支持

#### 任务4.3：修复其他核心文件
- [ ] `android/ext/Tools.java`
- [ ] `android/ext/MainService.java`
- [ ] `android/ext/Searcher.java`
- [ ] 所有`Script$*.java`文件

---

### 阶段五：自定义库迁移

#### 任务5.1：迁移GgLib
文件位置: `luaj/lib/GgLib.java`

需要修改的内容：
- [ ] 更新包名为`org.luaj.vm2.lib`
- [ ] 更新父类引用
- [ ] 更新LuaValue方法调用

#### 任务5.2：迁移自定义扩展
需要保留的自定义扩展：
- [ ] `lasm/` - Lua汇编器
- [ ] `luaj/lib/GgLib.java` - GG修改器专用库
- [ ] 自定义的安全IO库

---

### 阶段六：编译测试

#### 任务6.1：创建构建配置
- [ ] 创建Android项目结构
- [ ] 配置build.gradle
- [ ] 配置AndroidManifest.xml

#### 任务6.2：编译验证
- [ ] 解决编译错误
- [ ] 解决编译警告
- [ ] 确保所有类正确链接

#### 任务6.3：功能测试
- [ ] 测试Lua脚本执行
- [ ] 测试内存搜索功能
- [ ] 测试GG API兼容性

---

## 详细类名映射表

### 核心类映射

| 混淆名 | 原始名 | 说明 |
|-------|-------|------|
| `luaj.Globals` | `org.luaj.vm2.Globals` | 全局环境 |
| `luaj.LuaValue` | `org.luaj.vm2.LuaValue` | Lua值基类 |
| `luaj.LuaTable` | `org.luaj.vm2.LuaTable` | Lua表 |
| `luaj.LuaString` | `org.luaj.vm2.LuaString` | Lua字符串 |
| `luaj.LuaNumber` | `org.luaj.vm2.LuaNumber` | Lua数字 |
| `luaj.LuaBoolean` | `org.luaj.vm2.LuaBoolean` | Lua布尔 |
| `luaj.LuaNil` | `org.luaj.vm2.LuaNil` | Lua空值 |
| `luaj.LuaFunction` | `org.luaj.vm2.LuaFunction` | Lua函数 |
| `luaj.LuaClosure` | `org.luaj.vm2.LuaClosure` | Lua闭包 |
| `luaj.LuaThread` | `org.luaj.vm2.LuaThread` | Lua线程 |
| `luaj.LuaDouble` | `org.luaj.vm2.LuaDouble` | Lua双精度 |
| `luaj.LuaLong` | `org.luaj.vm2.LuaInteger` | Lua整数 |
| `luaj.WeakTable` | `org.luaj.vm2.WeakTable` | 弱引用表 |

### 编译器相关类映射

| 混淆名 | 原始名 | 说明 |
|-------|-------|------|
| `luaj.a.a` | `org.luaj.vm2.compiler.Constants` | 常量 |
| `luaj.a.b` | `org.luaj.vm2.compiler.DumpState` | 转储状态 |
| `luaj.a.c` | `org.luaj.vm2.compiler.FuncState` | 函数状态 |
| `luaj.a.d` | `org.luaj.vm2.compiler.InstructionPtr` | 指令指针 |
| `luaj.a.e` | `org.luaj.vm2.compiler.IntPtr` | 整数指针 |
| `luaj.a.f` | `org.luaj.vm2.compiler.LexState` | 词法状态 |
| `luaj.a.g` | `org.luaj.vm2.compiler.LuaC` | Lua编译器 |

### 库类映射

| 混淆名 | 原始名 | 说明 |
|-------|-------|------|
| `luaj.lib.BaseLib` | `org.luaj.vm2.lib.BaseLib` | 基础库 |
| `luaj.lib.MathLib` | `org.luaj.vm2.lib.MathLib` | 数学库 |
| `luaj.lib.StringLib` | `org.luaj.vm2.lib.StringLib` | 字符串库 |
| `luaj.lib.TableLib` | `org.luaj.vm2.lib.TableLib` | 表库 |
| `luaj.lib.DebugLib` | `org.luaj.vm2.lib.DebugLib` | 调试库 |
| `luaj.lib.OsLib` | `org.luaj.vm2.lib.OsLib` | 系统库 |
| `luaj.lib.IoLib` | `org.luaj.vm2.lib.IoLib` | IO库 |
| `luaj.lib.PackageLib` | `org.luaj.vm2.lib.PackageLib` | 包库 |
| `luaj.lib.Bit32Lib` | `org.luaj.vm2.lib.Bit32Lib` | 位运算库 |
| `luaj.lib.Utf8Lib` | `org.luaj.vm2.lib.Utf8Lib` | UTF8库 |
| `luaj.lib.GgLib` | **自定义** | GG修改器专用库 |

---

## 方法名映射表

### LuaValue方法

| 混淆名 | 原始名 | 说明 |
|-------|-------|------|
| `f_()` | `typename()` | 获取类型名 |
| `c(int)` | `arg(int)` | 获取参数 |
| `j_()` | `narg()` | 参数数量 |
| `h(String)` | `error(String)` | 抛出错误 |
| `a(LuaValue)` | `get(LuaValue)` | 获取表项 |
| `b(LuaValue, LuaValue)` | `set(LuaValue, LuaValue)` | 设置表项 |
| `a_()` | `checknotnil()` | 检查非空 |
| `g_()` | `tojstring()` | 转Java字符串 |

### Globals方法

| 混淆名 | 原始名 | 说明 |
|-------|-------|------|
| `c()` | `checkglobals()` | 检查全局 |
| `a(InputStream, String, String, LuaValue)` | `load(...)` | 加载代码 |
| `a(InputStream, String)` | `compilePrototype(...)` | 编译原型 |
| `c_(String)` | `loadfile(String)` | 加载文件 |
| `d(String)` | `findFile(String)` | 查找文件 |

---

## 预估工作量

| 阶段 | 预估时间 | 优先级 |
|-----|---------|-------|
| 阶段一：准备工作 | 2-4小时 | 高 |
| 阶段二：luaj库替换 | 4-6小时 | 高 |
| 阶段三：代码适配 | 8-12小时 | 高 |
| 阶段四：核心文件修复 | 6-8小时 | 高 |
| 阶段五：自定义库迁移 | 2-4小时 | 中 |
| 阶段六：编译测试 | 4-8小时 | 高 |

**总计：26-42小时**

---

## 风险评估

### 高风险项
1. **API不兼容**：luaj 3.0.2与当前版本API差异较大
2. **自定义功能丢失**：GG修改器的自定义扩展可能无法直接迁移
3. **性能问题**：新版本可能有性能差异

### 中风险项
1. **编译错误**：大量代码需要修改
2. **运行时错误**：方法签名变化可能导致运行时错误

### 低风险项
1. **代码风格**：代码风格差异不影响功能
2. **文档缺失**：可通过测试补充

---

## 下一步行动

1. 确认计划后，开始执行阶段一
2. 建立完整的类名/方法名映射表
3. 逐步替换和测试

---

*计划创建时间: 2026-03-05*
*计划版本: 1.0*
