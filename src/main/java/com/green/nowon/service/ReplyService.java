package com.green.nowon.service;

import java.util.ArrayList;

import org.springframework.ui.Model;

import com.green.nowon.dto.ReplyDTO;

public interface ReplyService {

	void replySave(ReplyDTO dto);

	ArrayList<ReplyDTO> findByPcodeList(int pcode, Model model);

}
