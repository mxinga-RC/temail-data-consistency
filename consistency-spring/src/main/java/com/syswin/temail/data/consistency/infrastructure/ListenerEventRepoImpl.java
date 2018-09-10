package com.syswin.temail.data.consistency.infrastructure;

import com.syswin.temail.data.consistency.domain.ListenerEvent;
import com.syswin.temail.data.consistency.domain.ListenerEventRepo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ListenerEventRepoImpl implements ListenerEventRepo {

  private final ListenerEventMapper eventMapper;

  @Autowired
  public ListenerEventRepoImpl(ListenerEventMapper eventMapper) {
    this.eventMapper = eventMapper;
  }

  @Override
  public Integer save(ListenerEvent listenerEvent) {
    return eventMapper.insert(listenerEvent);
  }

  @Override
  public List<ListenerEvent> findReadyToSend() {
    return eventMapper.selectReadyToSend();
  }

  @Override
  public Integer updateStatus(Long id, String status) {
    return eventMapper.updateStatusById(id,status);
  }
}