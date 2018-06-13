package com.jdbcio.app;

import org.apache.beam.sdk.Pipeline;
import org.apache.beam.sdk.coders.StringUtf8Coder;
import org.apache.beam.sdk.io.TextIO;
import org.apache.beam.sdk.io.jdbc.JdbcIO;
import org.apache.beam.sdk.options.PipelineOptions;
import org.apache.beam.sdk.options.PipelineOptionsFactory;
import org.apache.beam.sdk.transforms.DoFn;
import org.apache.beam.sdk.transforms.ParDo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.ResultSet;
import java.util.TimeZone;

public class Main {

    private static final Logger LOG = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {

        // Set timezone
        TimeZone timeZone = TimeZone.getTimeZone("Asia/Tokyo");
        TimeZone.setDefault(timeZone);

        // init options
        PipelineOptionsFactory.register(Options.class);
        Options options = PipelineOptionsFactory
                .fromArgs(args)
                .withValidation()
                .as(Options.class);


        // create pipeline
        Pipeline p = Pipeline.create(options);


        // set JDBC
        String username = "XXXX";
        String password = "XXXX";
        String sql = "XXXX";
        String oracleUrl = "XXXX";

        JdbcIO.DataSourceConfiguration dataSource = JdbcIO
                .DataSourceConfiguration.create("oracle.jdbc.driver.OracleDriver", oracleUrl)
                .withUsername(username)
                .withPassword(password);

        p
                // batch read from JDBC Oracle
                .apply(JdbcIO
                        .<String>read()
                        .withDataSourceConfiguration(dataSource)
                        .withQuery(sql)
                        .withCoder(StringUtf8Coder.of())
                        .withRowMapper(new JdbcIO.RowMapper<String>() {
                            @Override
                            public String mapRow(ResultSet resultSet) throws Exception {
                                return resultSet.getString(1);
                            }
                        })
                )

                // Test: Change to String & Show log
                .apply(ParDo.of(new DoFn<String, String>() {
                    @ProcessElement
                    public void processElement(ProcessContext c) {

                        String row = c.element();
                        LOG.info("[rsv_no]: " + String.valueOf(row));
                        c.output(row);
                    }
                }))
                // Tes: Write to local file
                .apply(TextIO.write().to("XXXX"))
        ;
        p.run();
    }

    interface Options extends PipelineOptions {
    }
}
