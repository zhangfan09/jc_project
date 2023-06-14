package com.jc.mybatisplus;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jc.mybatisplus.enums.SexEnum;
import com.jc.mybatisplus.mapper.ProductMapper;
import com.jc.mybatisplus.mapper.UserMapper;
import com.jc.mybatisplus.pojo.Product;
import com.jc.mybatisplus.pojo.User;
import com.jc.mybatisplus.service.IProductSerivce;
import com.jc.mybatisplus.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class MybatisPlusTest {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private ProductMapper productMapper;
    @Autowired
    private UserService userService;
    @Autowired
    private IProductSerivce productService;

    @Test
    public void testSelectList() {
        //查询条件构造器查询一个list集合，若没有条件，则可以设置null为参数。
//        List<User> userList = userMapper.selectList(null);
//        userList.forEach(System.out::println);
        //自定义查询
//        Map<String, Object> map = userMapper.selectMapById(1l);
//        System.out.println("map = " + map);
        //组装排序查询
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.like("name", "小沥青");
        queryWrapper.between("age", 1, 2);
        queryWrapper.isNotNull("email");
        queryWrapper.orderByDesc("age");//按年龄降序
//        queryWrapper.orderByAsc("id");
        //==>  Preparing: SELECT id,name,age,email,is_delete_flag FROM user
        // WHERE (name LIKE ? AND age BETWEEN ? AND ? AND email IS NOT NULL)
        List list = userMapper.selectList(queryWrapper);
        System.out.println("list = " + list);

    }

    @Test
    public void testInsert() {//id
        User user = new User();
        user.setName("小沥青");
        user.setAge(2);
        user.setEmail("xiaoliqing@baomidou.com");
        int result = userMapper.insert(user);
        System.out.println("result = " + result);//soutv
        //id:1667894367018676226 并非自动递增主键，默认为雪花算法生成。数据库采用bigint，实体类采用Long类型
        System.out.println("id:" + user.getId());
        System.out.println();//sout
        System.out.println("MybatisPlusTest.testInsert");//soutm
        System.out.println();//soutp
    }

    @Test
    public void testDelete() {
       /* int status = 1;
        if (status == 1) {
            int result = userMapper.deleteById(1667894367018676226l);
            System.out.println("result = " + result);
        } else if (status == 2) {//多个筛选条件删除
            Map<String, Object> map = new HashMap<>();
            map.put("id", 1667894367018676226l);
            map.put("name", "小沥青");
            map.put("age", 2);
            int result = userMapper.deleteByMap(map);
            System.out.println("result = " + result);
        } else {//批量删除
            List<Long> list = Arrays.asList(1l, 2l, 3l);//由于是Long 类型 加上L。
            int result = userMapper.deleteBatchIds(list);
            System.out.println("result = " + result);
        }*/
        //组装删除，删除email为空的数据。
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.isNull("email");
        //==>  Preparing: DELETE FROM user WHERE (email IS NULL)
        int result = userMapper.delete(queryWrapper);
        System.out.println("result = " + result);
    }

    @Test
    public void testUpdate() {
        /*User user = new User();
        user.setId(1L);
        user.setName("Jone");
        int result = userMapper.updateById(user);
        System.out.println("result = " + result);*/
        //将
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.like("name", "小沥青");
        queryWrapper.gt("age", 1);
        queryWrapper.or();
        queryWrapper.isNull("email");
        //queryWrapper.and(i ->  i.lt("age", 9).ne("name", "小沥青"));
        User user = new User();
        user.setAge(10);
        //==>  Preparing: UPDATE user SET age=? WHERE (name LIKE ? AND age > ? OR email IS NULL)
        int result = userMapper.update(user, queryWrapper);
        System.out.println("result = " + result);
        String username = null;
        //lambda表达式内的逻辑优先运算
        queryWrapper.like("name", "小沥青");
        //判定字段不为null时，执行此条件
        queryWrapper.like(StringUtils.isNotBlank(username), "name", "a");
        //子sql查询
        queryWrapper.inSql("id", "select id from user where id <= 3");

    }

    @Test
    public void testPage() {
        //设置分页参数
        Page<User> page = new Page<>(1, 5);
        userMapper.selectPage(page, null);
        //获取分页数据
        List<User> list = page.getRecords();
        list.forEach(System.out::println);
        System.out.println("当前页：" + page.getCurrent());
        System.out.println("每页显示的条数：" + page.getSize());
        System.out.println("总记录数：" + page.getTotal());
        System.out.println("总页数：" + page.getPages());
        System.out.println("是否有上一页：" + page.hasPrevious());
        System.out.println("是否有下一页：" + page.hasNext());
    }

    @Test
    public void testSelectPageVo() {
        //设置分页参数
        Page<User> page = new Page<>(1, 5);
        userMapper.selectPageVo(page, 4);
        //获取分页数据
        List<User> list = page.getRecords();
        list.forEach(System.out::println);
        System.out.println("当前页：" + page.getCurrent());
        System.out.println("每页显示的条数：" + page.getSize());
        System.out.println("总记录数：" + page.getTotal());
        System.out.println("总页数：" + page.getPages());
        System.out.println("是否有上一页：" + page.hasPrevious());
        System.out.println("是否有下一页：" + page.hasNext());
    }

    /**
     * 不加乐观锁，悲观锁，预期数据与实际不一致。
     */
    @Test
    public void testConcurrentUpdate() {
        //1、小李
        Product p1 = productMapper.selectById(1L);
        System.out.println("小李取出的价格：" + p1.getPrice());
        //2、小王
        Product p2 = productMapper.selectById(1L);
        System.out.println("小王取出的价格：" + p2.getPrice());
        //3、小李将价格加了50元，存入了数据库
        p1.setPrice(p1.getPrice() + 50);
        int result1 = productMapper.updateById(p1);
        System.out.println("小李修改结果：" + result1);
        //4、小王将商品减了30元，存入了数据库
        p2.setPrice(p2.getPrice() - 30);
        int result2 = productMapper.updateById(p2);
        System.out.println("小王修改结果：" + result2);
        //最后的结果
        Product p3 = productMapper.selectById(1L);
        //价格覆盖，最后的结果：70
        System.out.println("最后的结果：" + p3.getPrice());
    }

    /**
     * 乐观锁实现流程
     * 1.数据库中添加version字段
     * 2.取出记录时，获取当前version
     * 3.更新时，version + 1，如果where语句中的version版本不对，则更新失败
     */
    @Test
    public void testConcurrentVersionUpdate() {
        //小李取数据
        Product p1 = productMapper.selectById(1L);
        //小王取数据
        Product p2 = productMapper.selectById(1L);
        //小李修改 + 50
        p1.setPrice(p1.getPrice() + 50);
        int result1 = productMapper.updateById(p1);
        System.out.println("小李修改的结果：" + result1);
        //小王修改 - 30
        p2.setPrice(p2.getPrice() - 30);
        int result2 = productMapper.updateById(p2);
        System.out.println("小王修改的结果：" + result2);
        if (result2 == 0) {
            //失败重试，重新获取version并更新
            p2 = productMapper.selectById(1L);
            p2.setPrice(p2.getPrice() - 30);
            result2 = productMapper.updateById(p2);
        }
        System.out.println("小王修改重试的结果：" + result2);
        //老板看价格
        Product p3 = productMapper.selectById(1L);
        System.out.println("老板看价格：" + p3.getPrice());
    }

    @Test
    public void testSexEnum(){
        User user = new User();
        user.setName("Enum");
        user.setAge(20);
        //设置性别信息为枚举项，会将@EnumValue注解所标识的属性值存储到数据库
        user.setSex(SexEnum.MALE);
        //==>  Preparing: INSERT INTO user ( id, name, age, sex ) VALUES ( ?, ?, ?, ? )
        //==> Parameters: 1668165832923697153(Long), Enum(String), 20(Integer), 1(Integer)
        int result = userMapper.insert(user);
        System.out.println("result = " + result);
    }

    /**
     * 测试多数据源
     */
    @Test
    public void testDynamicDataSource(){
        System.out.println(userService.getById(1L));//master
        System.out.println(productService.getById(1L));//slave_1
    }
}
