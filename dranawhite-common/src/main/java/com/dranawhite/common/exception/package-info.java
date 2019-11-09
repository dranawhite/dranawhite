/**
 * 异常设计
 * <pre>
 *     在系统中异常和错误码共同组成了系统的异常响应值，程序的维护人员根据异常和错误码可以轻易的分辨出系统中的问题，并加以修复；
 * </pre>
 *
 * <pre>
 * 异常：
 *      异常作为系统的第一级对外响应，在Web系统中根据异常的类别返回不同的HTTP响应码，异常可以分为对外异常和对内异常；
 *      对外异常用于在统一异常处理中区分不同的HTTP响应，常见的对外异常有：
 *      1) RequestException         400     请求错误
 *      2) AuthorizationException   401     认证错误
 *      3) AccessException          403     禁止访问
 *      4) ConflictException        407     访问冲突(唯一性、幂等性校验)
 *      5) SystemException          500     服务器内部异常
 *
 *      对内异常多是业务异常或者系统异常，用于在不同的业务场景中进行再次封装，例如根据用户ID查询用户不存在时抛出UserException，在
 *  认证的流程中，对UserException进行再次封装为AccessException；在添加用户的流程中再次封装为RequestException；在审批流获取用户信息
 *  的流程中，再次封装为SystemException。
 *      常见的对内异常有，根据实际常见创建：
 *      1) RpcException
 *      2) UserException
 *      3) RedisException
 *      4) MysqlException
 *      5) NotSupportedException
 *      6) BusinessException
 * </pre>
 *
 * <pre>
 * 错误码：
 *      错误码的设计用来区分详细的异常场景，给用户友好的文本提示，同时研发人员也可以仅仅凭借错误码快速的判断出发生异常的原因，而避免查
 *  日志甚至代码的时间损耗。
 *      错误码多适用于SystemException场景，多用枚举类表示，如：
 *      public enum GenericResultCode implements IResultCode {
 *          SYSTEM_ERROR(100000,"系统异常"),
 *          ARGUMENT_ERROR(1000001,"参数错误"),
 *          NOT_SUPPORTED(1000002,"尚未支持"),
 *          CONFLICT(1000003,"资源冲突"),
 *
 *          REQUEST_INVALID(4000000,"非法请求"),
 *          UNAUTHORIZED(4000001,"认证失败"),
 *          FORBIDDEN(4000003,"禁止访问"),
 *
 *          USER_NOT_EXIST(5000001,"用户不存在");
 *      }
 *
 *      错误码的文本描述分为两类：一类是内部描述，用于打印日志；一类是外部描述，用于显示给用户，外部描述可以在分布式配置系统中配置文本
 *  格式，根据异常和错误码Code值进行匹配。
 *      例如，在创建资源时，需要根据名称校验资源的唯一性，现在有创建用户和创建角色两个动作，在发生唯一性冲突时，抛出的异常都是
 *  ConflictException，此时可以根据错误码Code匹配对应的文本描述，分别是用户已存在Name=[{}]和角色已存在Name=[{}]
 * </pre>
 */
package com.dranawhite.common.exception;