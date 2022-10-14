package org.ait.project.boardingtest.shared.transform;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.ait.project.boardingtest.shared.dto.template.PaginationConfig;
import org.ait.project.boardingtest.shared.dto.template.ResponseCollection;
import org.ait.project.boardingtest.shared.dto.template.ResponseDetail;
import org.ait.project.boardingtest.shared.dto.template.ResponseList;
import org.ait.project.boardingtest.shared.dto.template.ResponseSchema;
import org.ait.project.boardingtest.shared.dto.template.ResponseTemplate;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-10-14T14:57:53+0700",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 1.8.0_202 (Oracle Corporation)"
)
@Component
public class ResponseTemplateTransformImpl implements ResponseTemplateTransform {

    @Override
    public ResponseTemplate templateDetail(ResponseSchema responseSchema, Object body) {
        if ( responseSchema == null && body == null ) {
            return null;
        }

        ResponseTemplate responseTemplate = new ResponseTemplate();

        if ( responseSchema != null ) {
            responseTemplate.setResponseSchema( responseSchema );
        }
        if ( body != null ) {
            responseTemplate.setResponseOutput( createDetail( body ) );
        }

        return responseTemplate;
    }

    @Override
    public ResponseDetail createDetail(Object body) {
        if ( body == null ) {
            return null;
        }

        ResponseDetail responseDetail = new ResponseDetail();

        responseDetail.setDetail( body );

        return responseDetail;
    }

    @Override
    public ResponseTemplate templateError(ResponseSchema responseSchema, Object body) {
        if ( responseSchema == null && body == null ) {
            return null;
        }

        ResponseTemplate responseTemplate = new ResponseTemplate();

        if ( responseSchema != null ) {
            responseTemplate.setResponseSchema( responseSchema );
        }
        if ( body != null ) {
            responseTemplate.setResponseOutput( body );
        }

        return responseTemplate;
    }

    @Override
    public ResponseTemplate templateCollection(ResponseSchema responseSchema, Page page, List contents) {
        if ( responseSchema == null && page == null && contents == null ) {
            return null;
        }

        ResponseTemplate responseTemplate = new ResponseTemplate();

        if ( responseSchema != null ) {
            responseTemplate.setResponseSchema( responseSchema );
        }
        responseTemplate.setResponseOutput( createResponseList(page,contents) );

        return responseTemplate;
    }

    @Override
    public ResponseCollection createResponseCollection(PaginationConfig paginationConfig, List content) {
        if ( paginationConfig == null && content == null ) {
            return null;
        }

        ResponseCollection responseCollection = new ResponseCollection();

        if ( paginationConfig != null ) {
            responseCollection.setPaginationConfig( paginationConfig );
        }
        if ( content != null ) {
            List list = content;
            if ( list != null ) {
                responseCollection.setContent( new ArrayList( list ) );
            }
        }

        return responseCollection;
    }

    @Override
    public PaginationConfig pageCollection(Integer number, Integer size, Long totalPage) {
        if ( number == null && size == null && totalPage == null ) {
            return null;
        }

        PaginationConfig paginationConfig = new PaginationConfig();

        if ( number != null ) {
            paginationConfig.setPage( number );
        }
        if ( size != null ) {
            paginationConfig.setSize( size );
        }
        if ( totalPage != null ) {
            paginationConfig.setTotal( totalPage );
        }

        return paginationConfig;
    }

    @Override
    public ResponseList createResponseListFromCollection(ResponseCollection responseCollection) {
        if ( responseCollection == null ) {
            return null;
        }

        ResponseList responseList = new ResponseList();

        responseList.setList( responseCollection );

        return responseList;
    }
}
