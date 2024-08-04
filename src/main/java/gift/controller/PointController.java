package gift.controller;

import gift.dto.PointRequest;
import gift.model.Member;
import gift.service.MemberService;
import gift.util.JwtUtil;
import io.jsonwebtoken.Claims;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/points")
public class PointController {

    @Autowired
    private final MemberService memberService;
    private final JwtUtil jwtUtil;

    public PointController(MemberService memberService, JwtUtil jwtUtil) {
        this.memberService = memberService;
        this.jwtUtil = jwtUtil;
    }


    @PostMapping("/add")
    public ResponseEntity<?> addPoint(@RequestBody PointRequest pointRequest) {
        memberService.addPoint(pointRequest.getMember_id(), pointRequest.getPoint());
        return ResponseEntity.ok().build();
    }
