package com.hthyaq.learnadmin.common.config;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.aop.Advisor;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.interceptor.DefaultTransactionAttribute;
import org.springframework.transaction.interceptor.NameMatchTransactionAttributeSource;
import org.springframework.transaction.interceptor.TransactionInterceptor;

/**
 * 全局事务配置
 */
@Aspect
@Configuration
public class GlobalTransactionConfig {
    private static final String POINTCUT_EXPRESSION = "execution (public * com.hthyaq.learnadmin.service.impl.*ServiceImpl.*(..))";

    @Autowired
    private PlatformTransactionManager transactionManager;

    @Bean
    @ConditionalOnMissingBean
    public TransactionInterceptor txAdvice() {
        DefaultTransactionAttribute tx_require = new DefaultTransactionAttribute();
        tx_require.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);

        DefaultTransactionAttribute tx_readonly = new DefaultTransactionAttribute();
        tx_readonly.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
        tx_readonly.setReadOnly(true);

        NameMatchTransactionAttributeSource source = new NameMatchTransactionAttributeSource();
        //增加
        source.addTransactionalMethod("insert*", tx_require);
        source.addTransactionalMethod("add*", tx_require);
        source.addTransactionalMethod("save*", tx_require);
        //删除
        source.addTransactionalMethod("delete*", tx_require);
        source.addTransactionalMethod("remove*", tx_require);
        //修改
        source.addTransactionalMethod("update*", tx_require);
        //查询
        source.addTransactionalMethod("get*", tx_readonly);
        source.addTransactionalMethod("query*", tx_readonly);
        source.addTransactionalMethod("find*", tx_readonly);
        source.addTransactionalMethod("list*", tx_readonly);
        source.addTransactionalMethod("count*", tx_readonly);
        source.addTransactionalMethod("page*", tx_readonly);
        return new TransactionInterceptor(transactionManager, source);
    }

    @Bean
    @ConditionalOnMissingBean
    public Advisor txAdviceAdvisor() {
        AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
        pointcut.setExpression(POINTCUT_EXPRESSION);
        return new DefaultPointcutAdvisor(pointcut, txAdvice());
    }
}
