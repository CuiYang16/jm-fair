package cn.edu.imut.jm.fair.domain.fair.facade;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.imut.jm.fair.domain.journal.service.JournalDetailService;
import cn.edu.imut.jm.journal.domain.journal.valobj.JournalDetailVo;

@Service
public class FairFacade {

	@Autowired
	private JournalDetailService journalDetailService;

	public List<JournalDetailVo> getAllJournal() {
		return journalDetailService.selectJournals();
	}
}
