/**
 * vue中computed和methods的区别
 *  methods是每次调用都会一步步执行函数内部的步骤
 *  computed是有缓存机制的，如果基础的值没有变动，它会跳过中间的步骤，直接返回上一次派生出的结果
 * 
 * vue中watch是干什么的
 *  监听数据变化的，可以通过handler方法让组件加载时就执行一次；
 *  deep：true实现数组与对象的深度监听
 * 
 * es6中Promise与async
 *  
 * 
 * for in和for of的区别
 *  in可以遍历对象和json，将属性作为key，of不可以
 *  in和of都可以遍历数组，in返回的是key，of返回的时value
 * 
 * 箭头函数和普通函数的特点
 *  箭头函数，不能当作Genertor函数，不能使用yield关键词
 *  箭头函数的this，获取的是上下文的this，并箭头函数调用call方法或者apply方法，不会影响this的指向
 *  箭头函数没有arguments了，可以用扩展符...代替
 *  箭头函数没有原型，它的prototype为undefined
 */