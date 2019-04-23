package cn.edu.imut.jm.fair.domain.journal.service;

import org.springframework.cloud.netflix.feign.FeignClient;

import cn.edu.imut.jm.journal.interfaces.facade.controller.api.JournalDetailServiceRemoteApi;

@FeignClient(value = "jm-journal")
public interface JournalDetailService extends JournalDetailServiceRemoteApi {

}
